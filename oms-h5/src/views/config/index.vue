<template>
<div class="app-container calendar-list-container">
  <!-- 筛选条件 -->
  <div class="filter-container">
  </div>

  <!-- 列表数据 -->
  <Pagination uri="/configs" :request-params="params" ref="pagination">

      <!-- 名称 -->
      <el-table-column align="center" label="名称"  >
        <template scope="scope">
          <span>{{scope.row.name}}</span>
        </template>
      </el-table-column>

      <!-- 键 -->
      <el-table-column align="center" label="键"  >
        <template scope="scope">
          <span>{{scope.row.key}}</span>
        </template>
      </el-table-column>

      <!-- 值 -->
      <el-table-column align="center" label="值">
        <template scope="scope">
          <span>{{scope.row.value}}</span>
        </template>
      </el-table-column>    

    <el-table-column label="操作" align="center" width="150">
      <template scope="scope">
        <el-button size="small" type="text" @click="handleEdit(scope.row.id)">编辑</el-button>
      </template>
    </el-table-column>
  </Pagination>
</div>
</template>

<script>
import { remove } from '@/api//config'
import waves from '@/directive/waves.js'// 水波纹指令
import Pagination from '@/components/Pagination'

export default {
  name: 'config_list',
  components: { Pagination },
  directives: {
    waves
  },
  data() {
    return {
      params: {
        search_like_name: undefined
      }
    }
  },
  created() {
  },
  methods: {
    /**
     * 搜索系统参数
     */
    handleSearch() {
      this.$refs.pagination.pageRequest()
    },

    /**
     * 编辑系统参数
     */
    handleEdit(id) {
      this.$router.push({ path: '/config/edit', query: { id: id }})
    },

    /**
     * 创建系统参数
     */
    handleCreate() {
      this.$router.push({ path: '/config/edit' })
    },

    /**
     * 删除系统参数
     */
    handleDelete(row) {
      this.$confirm('确认删除该系统参数？').then(_ => {
        remove(row.id).then(response => {
          this.$refs.pagination.removeItem(row)
        })
      }).catch(_ => {})
    }
  }
}
</script>

