<template>
  <div class="app-container calendar-list-container">
    <!-- 筛选条件 -->
    <div class="filter-container">
      <el-input @keyup.enter.native="handleSearch" style="width: 160px;" class="filter-item" :placeholder="$t('role.name')" v-model="params.search_like_name">
      </el-input>
      <el-select v-model="params.search_eq_status" style="width: 120px" class="filter-item" clearable :placeholder="$t('message.status')">
        <el-option
          v-for="item in options.status"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>

      <el-button class="filter-item" type="primary" v-waves icon="search" @click="handleSearch">{{$t('message.search')}}</el-button>
      <el-button class="filter-item pull-right" type="success" icon="edit" @click="handleCreate">{{$t('message.add')}}</el-button>
    </div>

    <Pagination uri="/roles" :request-params="params" ref="pagination">
      <el-table-column align="center" :label="$t('role.name')">
        <template scope="scope">
          <span>{{scope.row.name}}</span>
        </template>
      </el-table-column>

      <el-table-column :label="$t('role.userCount')" align="center" width="140">
        <template scope="scope">
          <span>{{scope.row.adminCount}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" :label="$t('message.status')" width="100">
        <template scope="scope">
          <Status :status="scope.row.status"></Status>
        </template>
      </el-table-column>

     <el-table-column align="center" :label="$t('message.createTime')" width="190">
        <template scope="scope">
          <span>{{scope.row.createdTime | parseTime('{y}-{m}-{d} {h}:{i}')}}</span>
        </template>
      </el-table-column>

      <el-table-column label="操作" align="center" width="150">
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
import { remove, updateStatus } from '@/api/sys/role'
import waves from '@/directive/waves.js'// 水波纹指令
import Status from '@/components/Status'
import Pagination from '@/components/Pagination'
import hasPermission from '@/utils/permission'

export default {
  name: 'role_list',
  components: { Status, Pagination },
  directives: {
    waves
  },
  data() {
    return {
      params: {
        search_like_name: undefined,
        search_eq_status: undefined
      },
      options: {
        status: [
          {
            value: 0,
            label: '禁用'
          },
          {
            value: 1,
            label: '可用'
          }
        ]
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
     * 编辑角色
     */
    handleEdit(id) {
      this.$router.push({ path: '/sys/role/edit', query: { id: id }})
    },

    /**
     * 创建角色
     */
    handleCreate() {
      this.$router.push({ path: '/sys/role/edit' })
    },

    /**
     * 更新角色状态
     */
    handleUpdateStatus(row, status) {
      updateStatus(row.id, status).then(response => {
        this.handleSearch()
      })
    },

    /**
     * 删除角色
     */
    handleDelete(row) {
      this.$confirm('确认删除该角色？').then(_ => {
        remove(row.id).then(response => {
          this.$refs.pagination.removeItem(row)
        })
      }).catch(_ => {})
    },

    /**
     * 是否编辑权限
     */
    hasEditPermission() {
      return hasPermission('role:edit')
    },

    /**
     * 是否删除权限
     */
    hasDeletePermission() {
      return hasPermission('role:delete')
    }
  }
}
</script>

