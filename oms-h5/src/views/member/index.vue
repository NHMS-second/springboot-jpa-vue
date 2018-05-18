<template>
<div class="app-container calendar-list-container">
  <!-- 筛选条件 -->
  <div class="filter-container">
    <el-input @keyup.enter.native="handleSearch" style="width: 160px;" class="filter-item" :placeholder="$t('member.mobile')" v-model="params.search_like_mobile">
      </el-input>

      <el-input @keyup.enter.native="handleSearch" style="width: 160px;" class="filter-item" :placeholder="$t('member.email')" v-model="params.search_like_email">
      </el-input>


      <el-select v-model="params.search_eq_status" style="width: 120px" class="filter-item" clearable :placeholder="$t('message.status')">
      <el-option v-for="item in options.status"
        :key="item.value"
        :label="$t(item.label)"
        :value="item.value">
      </el-option>
    </el-select>

    <el-select v-model="params.search_eq_from" style="width: 160px" class="filter-item" clearable :placeholder="$t('member.regsterType')">
      <el-option v-for="item in ooss.bbbs"
        :key="item.value"
        :label="$t(item.label)"
        :value="item.value">
      </el-option>
    </el-select>


    <el-button class="filter-item" type="primary" v-waves icon="search" @click="handleSearch">{{$t('message.search')}}</el-button>
    <!-- <el-button class="filter-item pull-right" type="success" icon="edit" @click="handleCreate">添加</el-button> -->
    <el-button class="filter-item pull-right" type="success" icon="document" @click="handleDownload">{{$t('member.export')}}</el-button>
  </div>

  <!-- 列表数据 -->
  <Pagination uri="/members" :request-params="params" ref="pagination">

      <!-- 手机号 -->
      <el-table-column align="center" :label="$t('member.mobile')">
        <template scope="scope">
          <span>{{scope.row.mobile}}</span>
        </template>
      </el-table-column>

      <!-- 邮箱 -->
      <el-table-column align="center" :label="$t('member.email')">
        <template scope="scope">
          <span>{{scope.row.email}}</span>
        </template>
      </el-table-column>

      <!-- 用户状态 -->
      <el-table-column align="center" :label="$t('member.status')">
        <template scope="scope">
          <span v-text="getUserStatus(scope.row.status)"></span>
        </template>
      </el-table-column>

      <!-- 国家 -->
      <el-table-column align="center" :label="$t('member.country')">
        <template scope="scope">
          <span>{{scope.row.country}}</span>
        </template>
      </el-table-column>

      <!-- 语言 -->
      <el-table-column align="center" :label="$t('member.language')">
        <template scope="scope">
          <span>{{scope.row.language}}</span>
        </template>
      </el-table-column>

      <!-- 头像 -->
      <el-table-column align="center" :label="$t('member.avatar')">
        <template scope="scope">
          <img :width="60" :height="60" :src="scope.row.avatar" />
        </template>
      </el-table-column>

      <!-- 昵称 -->
      <el-table-column align="center" :label="$t('member.nickname')">
        <template scope="scope">
          <span>{{scope.row.nickname}}</span>
        </template>
      </el-table-column>

      <!-- 注册方式 -->
      <el-table-column align="center" :label="$t('member.from')">
        <template scope="scope">
          <span v-text="getUserFrom(scope.row.from)"></span>
        </template>
      </el-table-column>

      <!-- 创建时间 -->
      <el-table-column align="center" :label="$t('message.createTime')">
        <template scope="scope">
          <span>{{scope.row.createdTime | parseTime('{y}-{m}-{d} {h}:{i}')}}</span>
        </template>
      </el-table-column>

    <el-table-column :label="$t('message.handle')" align="center" width="150">
      <template scope="scope">
        <el-button v-if="scope.row.status != -2 " size="small" type="text" @click="handleUpdateStatus(scope.row, -2)">{{$t('member.black')}}</el-button>
        <el-button v-if="scope.row.status != 0 " size="small" type="text" @click="handleUpdateStatus(scope.row, 0)">{{$t('member.toNoraml')}}</el-button>
        <!-- <el-button size="small" type="text" @click="handleEdit(scope.row.id)">编辑</el-button> -->
      </template>
    </el-table-column>
  </Pagination>
</div>
</template>

<script>
import { remove, updateStatus } from '@/api//member'
import waves from '@/directive/waves.js'// 水波纹指令
import Pagination from '@/components/Pagination'
import Status from '@/components/Status'
import { memberStatusOptions, memberFromOptions } from '@/utils/constants'

export default {
  name: 'member_list',
  components: { Pagination, Status },
  directives: {
    waves
  },
  data() {
    return {
      params: {
        search_like_mobile: undefined,
        search_like_email: undefined,
        search_eq_status: undefined,
        search_eq_from: undefined
      },

      ooss: {
        bbbs: memberFromOptions
      },
      options: {
        status: memberStatusOptions
      }
    }
  },
  created() {
  },
  methods: {
    getUserStatus(status) {
      if (status === -2) {
        return this.$t('member.blacked')
      } else if (status === -1) {
        return this.$t('member.dayblacked')
      } else if (status === 0) {
        return this.$t('member.normal')
      }
    },
    getUserFrom(from) {
      var s = ''
      memberFromOptions.forEach(element => {
        if (element.value === from) {
          s = element.label
        }
      })
      return this.$t(s)
    },
    /**
     * 搜索会员
     */
    handleSearch() {
      this.$refs.pagination.pageRequest()
    },

    handleDownload() {
      var paramsVal = ''
      if (this.params.search_like_mobile !== undefined) {
        paramsVal = '&search_like_mobile=' + this.params.search_like_mobile
      }
      if (this.params.search_like_email !== undefined) {
        paramsVal = '&search_like_email=' + this.params.search_like_email
      }
      if (this.params.search_eq_status !== undefined) {
        paramsVal = '&search_eq_status=' + this.params.search_eq_status
      }
      if (this.params.search_eq_from !== undefined) {
        paramsVal = '&search_eq_from=' + this.params.search_eq_from
      }
      window.open('http://device.eyecloud.top:8098/member/export?language=zh' + paramsVal)
    },

    /**
     * 编辑会员
     */
    handleEdit(id) {
      this.$router.push({ path: '/member/edit', query: { id: id }})
    },

    /**
     * 创建会员
     */
    handleCreate() {
      this.$router.push({ path: '/member/edit' })
    },

    /**
     * 更新会员状态
     */
    handleUpdateStatus(row, status) {
      updateStatus(row.id, status).then(response => {
        this.handleSearch()
      })
    },

    /**
     * 删除会员
     */
    handleDelete(row) {
      this.$confirm('确认删除该会员？').then(_ => {
        remove(row.id).then(response => {
          this.$refs.pagination.removeItem(row)
        })
      }).catch(_ => {})
    }
  }
}
</script>

