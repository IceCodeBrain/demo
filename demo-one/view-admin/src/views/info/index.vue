<template>
  <div class="app-container">
    <div class="filter-container">
      <el-button size="small" class="filter-item" type="primary" @click="handleAdd()">添加</el-button>
      <el-button size="small" class="filter-item" type="primary" @click="handleAExport()">导出</el-button>
      <el-upload
          class="filter-item"
          style="margin-left: 10px; margin-right: 10px"
          accept=".xlsx"
          :headers="myHeaders"
          :on-success="handleSuccess"
          :on-error="handleError"
          :on-progress="handleProgress"
          v-loading.fullscreen.lock="fullscreenLoading"
          :show-file-list="false"
          :action="uploadUrl">
        <el-button size="small" type="primary">EXCEL导入</el-button>
      </el-upload>
    </div>

    <div>

      <el-table v-loading="listLoading" :data="list" max-height="800" border style="width: 100%">

        <el-table-column type="index" width="50" label="序号"></el-table-column>

        <el-table-column prop="code" align="center" label="地区编码"></el-table-column>

        <el-table-column prop="name" align="center" label="地区名称"></el-table-column>

        <el-table-column prop="info" align="center" label="天气"></el-table-column>

        <el-table-column prop="createTime" align="center" label="创建时间"></el-table-column>

        <el-table-column align="center" label="操作" fixed="right" width="120">

          <template #default="scope">

            <el-button type="text" size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>

            <el-button type="text" size="mini" style="color: red" @click="doDelete(scope.row.id)">
              删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div>
      <pagination :total="pageInfo.total"
                  :pageNum="requestDTO.pageNum"
                  :PageSize="requestDTO.pageSize"
                  @onSizeChange="handleSizeChange"
                  @onCurrentChange="handleCurrentChange"/>
    </div>

    <div>
      <!-- 编辑弹出框 -->
      <el-dialog title="添加/编辑" :visible.sync="editVisible" width="30%">
        <el-form :model="form" label-width="70px">
          <el-form-item label="地区编码">
            <el-input maxlength="32" show-word-limit v-model.trim="form.code"/>
          </el-form-item>
          <el-form-item label="地区名称">
            <el-input maxlength="32" show-word-limit v-model.trim="form.name"/>
          </el-form-item>
        </el-form>
        <template #footer>
                <span class="dialog-footer">
                    <el-button @click="editVisible = false">取 消</el-button>
                    <el-button type="primary" @click="doEdit">确 定</el-button>
                </span>
        </template>
      </el-dialog>
    </div>

    <div>
      <el-dialog title="批量导入失败数据列表" :visible.sync="dialogTableVisible">
        <el-card class="box-card">
          <div v-for="(message,index) in gridData" :key="index" class="text item">{{ index + '-->' + message }}</div>
        </el-card>
      </el-dialog>
    </div>

  </div>
</template>

<script>

import {doDeleteById, doEdit, doExport, doQueryByPage} from '@/api/info'
import Pagination from "@/components/Pagination";
import {getToken} from "@/utils/auth";
import {Message} from "element-ui";

export default {
  components: {Pagination},
  data() {
    return {
      gridData: [],
      dialogTableVisible: false,
      uploadUrl: null,
      myHeaders: {Authorization: getToken()},
      pageInfo: {
        endRow: 0,
        hasNextPage: true,
        hasPreviousPage: true,
        isFirstPage: true,
        isLastPage: true,
        list: [],
        nextPage: 0,
        pageNum: 0,
        pageSize: 0,
        pages: 0,
        prePage: 0,
        size: 0,
        startRow: 0,
        total: 0
      },
      list: null,
      fullscreenLoading: false,
      listLoading: true,
      form: {},
      requestDTO: {
        data: null,
        pageNum: 1,
        pageSize: 10
      },
      isAdd: false,
      editFrom: {},
      idx: -1,
      editVisible: false
    }
  },
  created() {
    this.uploadUrl = process.env.VUE_APP_BASE_API + "/admin/info/doImport";
    this.handleCurrentChange(1);
  },
  methods: {
    // 编辑操作
    handleEdit(index, row) {
      this.idx = index;
      this.form = row;
      this.isAdd = false;
      this.editVisible = true;
    },
    handleAdd() {
      this.form = {};
      this.isAdd = true;
      this.editVisible = true;
    },
    handleSizeChange(val) {
      this.requestDTO.pageSize = val;
      this.fetchData();
    },
    handleCurrentChange(val) {
      this.requestDTO.pageNum = val;
      this.fetchData();
    },
    fetchData() {
      this.listLoading = true;
      doQueryByPage(this.requestDTO).then(response => {
        this.listLoading = false;
        this.pageInfo = response.data;
        this.list = this.pageInfo.list;
      })
    },

    doEdit() {
      this.editFrom = this.form;
      if (this.isAdd) {
        this.editFrom.deviceId = null;
      }
      doEdit(this.editFrom).then(response => {
        if (response.code === 200) {
          this.editVisible = false;
          if (this.isAdd) {
            this.$message.success(`添加成功`);
            this.fetchData()
            // this.list.push(this.editFrom);
          } else {
            this.$message.success(`修改第 ${this.idx + 1} 行成功`);
          }
        }
      })
    },
    doDelete(id) {
      this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
        center: true
      }).then(() => {
        doDeleteById(id).then(response => {
          if (response.code === 200) {
            this.$message.success(`删除成功`);
            this.fetchData()
          }
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },

    handleAExport() {
      doExport(this.requestDTO).then(response => {
        console.log(response);
        const blob = new Blob([response]);
        const fileName = 'output.xlsx';
        if ('download' in document.createElement('a')) { // 非IE下载
          const emlink = document.createElement('a');
          emlink.download = fileName;
          emlink.style.display = 'none';
          emlink.href = URL.createObjectURL(blob);
          document.body.appendChild(emlink);
          emlink.click();
          URL.revokeObjectURL(emlink.href);// 释放URL 对象
          document.body.removeChild(emlink)
        } else { // IE10+下载
          navigator.msSaveBlob(blob, fileName)
        }
      })
    },

    downCode() {
      window.location.href = process.env.VUE_APP_BASE_API + "static/全国行政区域编号.xlsx";
      //window.open(process.env.VUE_APP_BASE_API + "/static/全国行政区域编号.xlsx")
    },

    handleProgress() {
      this.fullscreenLoading = true;
    },
    handleSuccess(response) {
      this.fullscreenLoading = false;
      if (response.code === 200) {
        this.gridData = response.data;
        if (this.gridData.length === 0) {
          Message('全部导入成功');
          this.fetchData();
          return;
        }
        this.dialogTableVisible = true;
        return;
      }
      Message(response.msg);
    },
    handleError(err) {
      console.log(err);
      this.fullscreenLoading = false;
    }
  },
}
</script>

<style scoped>

</style>
