<template>
<div class="app-container calendar-list-container">
  <!-- 筛选条件 -->
  <div class="filter-container">

  </div>

  <!-- 列表数据 -->
  <Pagination :uri="'/device/status/logs?deviceId='+deviceId" :request-params="params" ref="pagination">

      <!-- 事件 -->
      <el-table-column align="center" :label="$t('device.event')">
        <template scope="scope">
          <span v-text="getType(scope.row.type)"></span>
        </template>
      </el-table-column>

      <!-- 设备上下线时间 -->
      <el-table-column align="center" :label="$t('device.time')">
        <template scope="scope">
          <span>{{scope.row.time | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}</span>
        </template>
      </el-table-column>

  </Pagination>
</div>
</template>

<script>
import { remove } from '@/api//device/status/log'
import waves from '@/directive/waves.js'// 水波纹指令
import Pagination from '@/components/Pagination'

export default {
  name: 'deviceStatusLog_list',
  components: { Pagination },
  directives: {
    waves
  },
  data() {
    return {
      params: {
        deviceId: 0
      }
    }
  },
  created() {
    this.deviceId = this.$route.query.id
  },
  methods: {
    getType(type) {
      if (type === 1) {
        return this.$t('device.online')
      } else if (type === 2) {
        return this.$t('device.offline')
      }
    },
    /**
     * 搜索设备上下线记录
     */
    handleSearch() {
      this.$refs.pagination.pageRequest()
    },

    /**
     * 编辑设备上下线记录
     */
    handleEdit(id) {
      this.$router.push({ path: '/device/status/log/edit', query: { id: id }})
    },
    /**
     * 创建设备上下线记录
     */
    handleCreate() {
      this.$router.push({ path: '/device/status/log/edit' })
    },

    /**
     * 删除设备上下线记录
     */
    handleDelete(row) {
      this.$confirm('确认删除该设备上下线记录？').then(_ => {
        remove(row.id).then(response => {
          this.$refs.pagination.removeItem(row)
        })
      }).catch(_ => {})
    }
  }
}
</script>

