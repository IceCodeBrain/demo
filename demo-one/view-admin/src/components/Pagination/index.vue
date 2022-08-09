<template>
  <div :class="{'hidden':hidden}" class="pagination-container">
    <el-pagination
        v-show="total>0"
        :background="background"
        :current-page="pageNum"
        :layout="layout"
        :page-size="pageSize"
        :page-sizes="pageSizes"
        :total="total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"/>
  </div>
</template>

<script>
export default {
  name: 'Pagination',
  props: {
    total: {
      required: true,
      type: Number
    },
    pageNum: {
      type: Number,
      default: 1
    },
    pageSize: {
      type: Number,
      default: 10
    },
    pageSizes: {
      type: Array,
      default() {
        return [10, 20, 50, 100]
      }
    },
    layout: {
      type: String,
      default: 'total, sizes, prev, pager, next, jumper'
    },
    background: {
      type: Boolean,
      default: true
    },
    autoScroll: {
      type: Boolean,
      default: true
    },
    hidden: {
      type: Boolean,
      default: false
    }
  },
  methods: {
    handleSizeChange(val) {
      this.$emit('onSizeChange', val);
    },
    handleCurrentChange(val) {
      this.$emit('onCurrentChange', val);
    }
  }
}
</script>

<style scoped>
.pagination-container {
  background: #fff;
  padding: 10px 10px;
}

.pagination-container.hidden {
  display: none;
}
</style>
