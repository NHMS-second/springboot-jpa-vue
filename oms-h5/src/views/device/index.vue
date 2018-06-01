<template>
<div class="app-container calendar-list-container">
  <!-- 筛选条件 -->
  <div class="filter-container">
    
  <el-input @keyup.enter.native="handleSearch" style="width: 120px;" class="filter-item" :placeholder="$t('device.deviceId')" v-model="params.search_like_deviceSn"></el-input>
    <el-select v-model="params.search_eq_status" style="width: 160px" class="filter-item" clearable :placeholder="$t('device.status')">
      <el-option :label="$t('device.online')" :value="1"></el-option>
      <el-option :label="$t('device.offline')" :value="2"></el-option>
      <el-option :label="$t('device.error')" :value="3"></el-option>
    </el-select>
    <el-button class="filter-item" type="primary" v-waves icon="search" @click="handleSearch">{{$t('message.search')}}</el-button>
  </div>

  <!-- 列表数据 -->
  <Pagination uri="/devices" :request-params="params" ref="pagination" :showIndex="false">

        
      <!-- 用户ID -->
      <el-table-column align="center" :label="$t('device.memberId')">
        <template scope="scope">
          <span v-if="scope.row.member">{{scope.row.member.id}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" :label="$t('device.account')">
        <template scope="scope">
          <div v-if="scope.row.member">
            <span v-if="scope.row.member.mobile" v-text="scope.row.member.mobile"></span>
            <span v-if="scope.row.member.email" v-text="scope.row.member.email"></span>
          </div>
        </template>
      </el-table-column>

      <!-- 设备编号 -->
      <el-table-column align="center" :label="$t('device.deviceId')">
        <template scope="scope">
          <span>{{scope.row.deviceSn}}</span>
        </template>
      </el-table-column>

      <!-- 固件型号  -->
      <el-table-column align="center" :label="$t('device.status')">
        <template scope="scope">
         <el-tag :type="getStatusTag(scope.row.status)" v-text="getStatus(scope.row.status)"></el-tag>
        </template>
      </el-table-column>

      <el-table-column align="center" :label="$t('device.onlineTime')">
        <template scope="scope">
          <span v-text="getOnlineTime(scope.row.totalOnlineTime)"></span>
        </template>
      </el-table-column>

      <!-- 创建时间 -->
      <el-table-column align="center" :label="$t('device.lastOnlineTime')">
        <template scope="scope">
          <span>{{scope.row.onlineTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" :label="$t('device.lastOfflineTime')">
        <template scope="scope">
          <span>{{scope.row.offlineTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}</span>
        </template>
      </el-table-column>

    <el-table-column label="操作" align="center" width="150">
      <template scope="scope">        
        <el-button size="small" type="text" @click="handleShowLog(scope.row)">{{$t('device.onlineRecord')}}</el-button>
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
        return this.$t('device.online')
      } else if (status === 2) {
        return this.$t('device.offline')
      } else if (status === 3) {
        return this.$t('device.error')
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
    getOnlineTime(time) {
      var second = time
      var minute = 0
      var hour = 0
      var day = 0
      minute = parseInt(second / 60) // 算出一共有多少分钟
      second %= 60// 算出有多少秒
      if (minute > 60) { // 如果分钟大于60，计算出小时和分钟
        hour = parseInt(minute / 60)
        minute %= 60// 算出有多分钟
      }
      if (hour > 24) { // 如果小时大于24，计算出天和小时
        day = parseInt(hour / 24)
        hour %= 24// 算出有多分钟
      }
      return day + 'days ' + hour + 'hours ' + minute + 'minutes'
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

