<template>
  <div>
    <el-image :src="imgUrl"/>
  </div>
</template>
<script>

import avatarLog from '@/assets/background/bg.png'

export default {
  name: 'Dashboard',
  data() {
    return {

      imgUrl: avatarLog
    }
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }

  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
