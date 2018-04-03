<template>
  <div class="app-container calendar-list-container">
    <!-- 筛选条件 -->
    <div class="filter-container">
      <el-input @keyup.enter.native="handleSearch" style="width: 120px;" class="filter-item" :placeholder="$t('admin.name')" v-model="params.search_like_username">
      </el-input>
      <el-input @keyup.enter.native="handleSearch" style="width: 120px;" class="filter-item" :placeholder="$t('admin.phone')" v-model="params.search_like_mobile">
      </el-input>
      <el-input @keyup.enter.native="handleSearch" style="width: 200px;" class="filter-item" :placeholder="$t('admin.email')" v-model="params.search_like_email">
      </el-input>
      <el-select v-model="params.search_eq_status" style="width: 120px" class="filter-item" clearable :placeholder="$t('message.status')">
        <el-option
          v-for="item in options.status"
          :key="item.value"
          :label="$t(item.label)"
          :value="item.value">
        </el-option>
      </el-select>

      <el-button class="filter-item" type="primary" v-waves icon="search" @click="handleSearch">{{$t('message.search')}}</el-button>
      <el-button v-if="hasEditPermission()" class="filter-item pull-right" type="success" icon="edit" @click="handleCreate">{{$t('message.add')}}</el-button>
    </div>

    <Pagination uri="/admins" :request-params="params" ref="pagination">
      <el-table-column align="center" :label="$t('admin.name')">
        <template scope="scope">
          <span>{{scope.row.username}}</span>
        </template>
      </el-table-column>

      <el-table-column :label="$t('admin.phone')" align="center" width="140">
        <template scope="scope">
          <span>{{scope.row.mobile}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" :label="$t('admin.email')" width="220">
        <template scope="scope">
          <span>{{scope.row.email}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" :label="$t('admin.sex')" width="70">
        <template scope="scope">
          <Gender :gender="scope.row.gender"></Gender>
        </template>
      </el-table-column>

      <el-table-column align="center" :label="$t('message.status')" width="82">
        <template scope="scope">
          <Status :status="scope.row.status"></Status>
        </template>
      </el-table-column>

      <el-table-column align="center" :label="$t('message.createTime')" width="150">
        <template scope="scope">
          <span>{{scope.row.createdTime | parseTime('{y}-{m}-{d} {h}:{i}')}}</span>
        </template>
      </el-table-column>

      <el-table-column :label="$t('message.handle')" align="center" width="150">
        <template scope="scope">
          <el-button v-if="hasEditPermission() && scope.row.status === 1" size="small" type="text" @click="handleUpdateStatus(scope.row, 0)">{{$t('message.disable')}}</el-button>
          <el-button v-if="hasEditPermission() && scope.row.status === 0" size="small" type="text" @click="handleUpdateStatus(scope.row, 1)">{{$t('message.enable')}}</el-button>
          <el-button v-if="hasEditPermission()" size="small" type="text" @click="handleEdit(scope.row.id)">{{$t('message.edit')}}</el-button>
          <el-button v-if="hasDeletePermission()" size="small" type="text" class="danger" @click="handleDelete(scope.row)">{{$t('message.delete')}}</el-button>
        </template>
      </el-table-column>
    </Pagination>
  </div>
</template>

<script>
import { remove, updateStatus } from '@/api/sys/admin'
import waves from '@/directive/waves.js'// 水波纹指令
import Gender from '@/components/Gender'
import Status from '@/components/Status'
import { statusOptions } from '@/utils/constants'
import Pagination from '@/components/Pagination'
import hasPermission from '@/utils/permission'

export default {
  name: 'admin_list',
  components: { Gender, Status, Pagination },
  directives: {
    waves
  },
  data() {
    return {
      params: {
        search_like_username: undefined,
        search_like_mobile: undefined,
        search_like_email: undefined,
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
     * 搜索
     */
    handleSearch() {
      this.$refs.pagination.pageRequest()
    },

    /**
     * 编辑管理员
     */
    handleEdit(id) {
      this.$router.push({ path: '/sys/admin/edit', query: { id: id }})
    },

    /**
     * 创建管理员
     */
    handleCreate() {
      this.$router.push({ path: '/sys/admin/edit' })
    },

    /**
     * 更新管理员状态
     */
    handleUpdateStatus(row, status) {
      updateStatus(row.id, status).then(response => {
        this.handleSearch()
      })
    },

    /**
     * 判断是否编辑权限
     */
    hasEditPermission() {
      return hasPermission('admin:edit')
    },

    /**
     * 判断是否删除权限
     */
    hasDeletePermission() {
      console.info('delete permission', hasPermission('admin:delete'))
      return hasPermission('admin:delete')
    },

    /**
     * 删除管理员
     */
    handleDelete(row) {
      this.$confirm(this.$t('admin.delAdminTip')).then(_ => {
        remove(row.id).then(response => {
          this.$refs.pagination.removeItem(row)
        })
      }).catch(_ => {})
    }
  }
}
</script>

