<template>
<div class="app-container calendar-list-container">
  <!-- 筛选条件 -->
  <div class="filter-container">
    <el-input @keyup.enter.native="handleSearch" style="width: 120px;" class="filter-item" placeholder="设备昵称" v-model="params.search_like_nickname"></el-input>
  <el-input @keyup.enter.native="handleSearch" style="width: 120px;" class="filter-item" placeholder="设备编号" v-model="params.search_like_deviceSn"></el-input>
    <el-select v-model="params.search_eq_status" style="width: 120px" class="filter-item" clearable placeholder="状态">
      <el-option v-for="item in options.status"
        :key="item.value"
        :label="item.label"
        :value="item.value">
      </el-option>
    </el-select>

    <el-button class="filter-item" type="primary" v-waves icon="search" @click="handleSearch">搜索</el-button>
    <el-button class="filter-item pull-right" type="success" icon="edit" @click="handleCreate">添加</el-button>
  </div>

  <!-- 列表数据 -->
  <Pagination uri="/devices" :request-params="params" ref="pagination">

      <!-- 设备昵称 -->
      <el-table-column align="center" label="设备昵称">
        <template scope="scope">
          <span>{{scope.row.nickname}}</span>
        </template>
      </el-table-column>

      <!-- 设备编号 -->
      <el-table-column align="center" label="设备编号">
        <template scope="scope">
          <span>{{scope.row.deviceSn}}</span>
        </template>
      </el-table-column>

      <!-- 固件型号  -->
      <el-table-column align="center" label="固件型号 ">
        <template scope="scope">
          <span>{{scope.row.chipType}}</span>
        </template>
      </el-table-column>

      <!-- 创建时间 -->
      <el-table-column align="center" label="创建时间">
        <template scope="scope">
          <span>{{scope.row.createdTime | parseTime('{y}-{m}-{d} {h}:{i}')}}</span>
        </template>
      </el-table-column>

    <el-table-column label="操作" align="center" width="150">
      <template scope="scope">
        <el-button v-if="scope.row.status === 1" size="small" type="text" @click="handleUpdateStatus(scope.row, 0)">禁用</el-button>
        <el-button v-if="scope.row.status === 0" size="small" type="text" @click="handleUpdateStatus(scope.row, 1)">启用</el-button>
        <el-button size="small" type="text" @click="handleEdit(scope.row.id)">编辑</el-button>
        <el-button size="small" type="text" class="danger" @click="handleDelete(scope.row)">删除</el-button>
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
    /**
     * 搜索设备
     */
    handleSearch() {
      this.$refs.pagination.pageRequest()
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

