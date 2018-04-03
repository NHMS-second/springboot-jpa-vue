<template>
  <el-tag :type="type">{{statusName}}</el-tag>
</template>

<script>
export default {
  props: {
    status: {
      type: Number,
      required: true
    }
  },
  computed: {
    statusName() {
      if (this.status === 1) {
        return this.$t('message.enabled')
      } else if (this.status === 0) {
        return this.$t('message.disabled')
      } else if (this.status === -1) {
        return this.$t('message.blacked')
      } else {
        return this.$t('message.unknow')
      }
    },
    type() {
      if (this.status === 1) {
        return 'success'
      } else if (this.status === 0) {
        return 'danger'
      } else if (this.status === 0) {
        return 'danger'
      } else {
        return 'warning'
      }
    }
  }
}
</script>
