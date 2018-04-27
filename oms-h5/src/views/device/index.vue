<template>
<div class="app-container calendar-list-container">
  <!-- 筛选条件 -->
  <div class="filter-container">
    
  <el-input @keyup.enter.native="handleSearch" style="width: 120px;" class="filter-item" placeholder="设备编号" v-model="params.search_like_deviceSn"></el-input>
    <el-select v-model="params.search_eq_status" style="width: 120px" class="filter-item" clearable placeholder="状态">
      <el-option label="在线" :value="1"></el-option>
      <el-option label="离线" :value="2"></el-option>
      <el-option label="异常" :value="3"></el-option>
    </el-select>

    <el-button class="filter-item" type="primary" v-waves icon="search" @click="handleSearch">搜索</el-button>
  </div>

  <!-- 列表数据 -->
  <Pagination uri="/devices" :request-params="params" ref="pagination">
      <!-- 设备编号 -->
      <el-table-column align="center" label="设备编号">
        <template scope="scope">
          <span>{{scope.row.deviceSn}}</span>
        </template>
      </el-table-column>

      <!-- 固件型号  -->
      <el-table-column align="center" label="设备状态">
        <template scope="scope">
         <el-tag :type="getStatusTag(scope.row.status)" v-text="getStatus(scope.row.status)"></el-tag>
        </template>
      </el-table-column>

      <!-- 创建时间 -->
      <el-table-column align="center" label="最近登录时间">
        <template scope="scope">
          <span>{{scope.row.onlineTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="最近离线时间">
        <template scope="scope">
          <span>{{scope.row.offlineTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}</span>
        </template>
      </el-table-column>

    <el-table-column label="操作" align="center" width="150">
      <template scope="scope">        
        <el-button size="small" type="text" @click="handleShowLog(scope.row)">上下线记录</el-button>
      </template>
    </el-table-column>
  </Pagination>
</div>
</template>

<script>
import { remove, updateStatus } from '@/api/device'
import waves from '@/directive/waves.js'// 水波纹指令
import Pagination from '@/components/Pagination'
import Status from '@/components/Status'
import statusOptions from '@/utils/constants.js'

export default {
  name: 'device_list',
  components: { Pagination, Status },
  directives: {
    waves
  },
  data() {
    return {
      params: {
        search_like_nickname: undefined,
        search_like_deviceSn: undefined,
        search_eq_status: undefined
      },
      options: {
        status: statusOptions
      }
    }
  },
  created() {
  },
  methods: {
    getStatus(status) {
      if (status === 1) {
        return '在线'
      } else if (status === 2) {
        return '离线'
      } else if (status === 3) {
        return '异常'
      }
    },
    getStatusTag(status) {
      if (status === 1) {
        return 'success'
      } else if (status === 2) {
        return 'gray'
      } else if (status === 3) {
        return 'danger'
      }
    },
    /**
     * 搜索设备
     */
    handleSearch() {
      this.$refs.pagination.pageRequest()
    },
    handleShowLog(device) {
      this.$router.push({ path: '/device/status/log/index', query: { id: device.id }})
    },
    /**
     * 编辑设备
     */
    handleEdit(id) {
      this.$router.push({ path: '/device/edit', query: { id: id }})
    },

    /**
     * 创建设备
     */
    handleCreate() {
      this.$router.push({ path: '/device/edit' })
    },

    /**
     * 更新设备状态
     */
    handleUpdateStatus(row, status) {
      updateStatus(row.id, status).then(response => {
        this.handleSearch()
      })
    },

    /**
     * 删除设备
     */
    handleDelete(row) {
      this.$confirm('确认删除该设备？').then(_ => {
        remove(row.id).then(response => {
          this.$refs.pagination.removeItem(row)
        })
      }).catch(_ => {})
    }
  }
}
</script>

