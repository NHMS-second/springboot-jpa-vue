<template>
<div class="app-container calendar-list-container">
  <!-- 筛选条件 -->

  <!-- 列表数据 -->
  <Pagination :uri="'/device/key/logs?deviceKeyId='+deviceKeyId" :request-params="params" ref="pagination">

      <!-- 状态 -->
      <el-table-column align="center" label="状态">
        <template scope="scope">
          <span v-text="getStatus(scope.row.status)"></span>
        </template>
      </el-table-column>

      <!-- 创建时间 -->
      <el-table-column align="center" label="时间">
        <template scope="scope">
          <span>{{scope.row.createdTime | parseTime('{y}-{m}-{d} {h}:{i}')}}</span>
        </template>
      </el-table-column>
  </Pagination>
</div>
</template>

<script>
import { remove, updateStatus } from '@/api//device/key/log'
import waves from '@/directive/waves.js'// 水波纹指令
import Pagination from '@/components/Pagination'
import Status from '@/components/Status'
import statusOptions from '@/utils/constants.js'

export default {
  name: 'deviceKeyLog_list',
  components: { Pagination, Status },
  directives: {
    waves
  },
  data() {
    return {
      params: {
        search_eq_status: undefined,
        deviceKeyId: ''
      },
      options: {
        status: statusOptions
      }
    }
  },
  created() {
    this.deviceKeyId = this.$route.query.id
  },
  methods: {
    getStatus(status) {
      if (status === 0) {
        return '使用'
      } else if (status === 1) {
        return '回收'
      }
    },
    /**
     * 搜索设备ID使用记录
     */
    handleSearch() {
      this.$refs.pagination.pageRequest()
    },

    /**
     * 编辑设备ID使用记录
     */
    handleEdit(id) {
      this.$router.push({ path: '/device/key/log/edit', query: { id: id }})
    },

    /**
     * 创建设备ID使用记录
     */
    handleCreate() {
      this.$router.push({ path: '/device/key/log/edit' })
    },

    /**
     * 更新设备ID使用记录状态
     */
    handleUpdateStatus(row, status) {
      updateStatus(row.id, status).then(response => {
        this.handleSearch()
      })
    },

    /**
     * 删除设备ID使用记录
     */
    handleDelete(row) {
      this.$confirm('确认删除该设备ID使用记录？').then(_ => {
        remove(row.id).then(response => {
          this.$refs.pagination.removeItem(row)
        })
      }).catch(_ => {})
    }
  }
}
</script>

