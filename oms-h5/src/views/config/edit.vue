<template>
  <div class="app-container app-edit">
    <el-form class="small-space" :model="form" :rules="rules" ref="form" label-position="right" label-width="120px" style="width: 700px;">

      <!-- 名称 -->
      <el-form-item label="名称" prop="name">
        <el-input v-model="form.name" placeholder="请输入名称" :disabled="true"></el-input>
      </el-form-item>

      <!-- 键 -->
      <el-form-item label="键" prop="key">
        <el-input v-model="form.key" placeholder="请输入键" :disabled="true"></el-input>
      </el-form-item>

      <!-- 值 -->
      <el-form-item label="值" prop="value">
        <el-input v-model="form.value" placeholder="请输入值"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" :loading="onSubmit" @click="handleSave">保存</el-button>
        <el-button @click="handleCancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { find, save } from '@/api//config'

export default {
  data() {
    return {
      form: {
        id: undefined,
        name: '',
        key: '',
        value: '',
        enValue: ''
      },

      onSubmit: false,

      // 表单验证规则
      rules: {
//        mobile: [
//          { required: true, message: '请输入手机号码', trigger: 'blur' }
//        ],
//        username: [
//          { required: true, message: '请输入姓名', trigger: 'blur' },
//          { max: 15, message: '姓名长度不能超过15个字符', trigger: 'blur' }
//        ],
//        email: [
//          { required: true, message: '请输入邮箱', trigger: 'blur' },
//          { type: 'email', message: '您输入的邮箱格式不正确', trigger: 'blur' }
//        ],
//        password: [
//          { required: true, message: '请输入密码', trigger: 'blur' },
//          { min: 6, message: '密码长度不能少于6个字符', trigger: 'blur' }
//        ]
      }
    }
  },
  created() {
    if (this.$route.query.id) {
      this.form.id = this.$route.query.id
      this.findById(this.form.id)
    }
  },
  methods: {
    /**
     * 查询系统参数
     */
    findById(id) {
      find(id).then(response => {
        this.form.name = response.config.name
        this.form.key = response.config.key
        this.form.value = response.config.value
        this.form.enValue = response.config.enValue
      })
    },

    /**
     * 保存系统参数
     */
    handleSave() {
      this.$refs.form.validate(valid => {
        if (!valid) {
          return false
        }

        this.onSubmit = true
        save(this.form).then(response => {
          this.$router.go(-1)
        }).finally(() => {
          this.onSubmit = false
        })
      })
    },

    /**
     * 取消
     */
    handleCancel() {
      this.$router.go(-1)
    }
  }
}
</script>
