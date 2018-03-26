<template>
  <div class="app-container app-edit">
    <el-form class="small-space" :model="form" :rules="rules" ref="form" label-position="right" label-width="120px" style="width: 700px;">

      <!-- 手机号 -->
      <el-form-item label="手机号" prop="mobile">
        <el-input v-model="form.mobile" placeholder="请输入手机号"></el-input>
      </el-form-item>

      <!-- 邮箱 -->
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="form.email" placeholder="请输入邮箱"></el-input>
      </el-form-item>

      <!-- 密码 -->
      <el-form-item label="密码" prop="password">
        <el-input v-model="form.password" placeholder="请输入密码"></el-input>
      </el-form-item>

      <!-- 密码盐 -->
      <el-form-item label="密码盐" prop="salt">
        <el-input v-model="form.salt" placeholder="请输入密码盐"></el-input>
      </el-form-item>

      <!-- 第三方登录ID -->
      <el-form-item label="第三方登录ID" prop="authId">
        <el-input v-model="form.authId" placeholder="请输入第三方登录ID"></el-input>
      </el-form-item>

      <!-- 状态 -->
      <el-form-item label="状态">
        <el-radio class="radio" v-model="form.status" :label="1">可用</el-radio>
        <el-radio class="radio" v-model="form.status" :label="0">禁用</el-radio>
      </el-form-item>

      <!--  -->
      <el-form-item label="" prop="country">
        <el-input v-model="form.country" placeholder="请输入"></el-input>
      </el-form-item>

      <!--  -->
      <el-form-item label="" prop="language">
        <el-input v-model="form.language" placeholder="请输入"></el-input>
      </el-form-item>

      <!--  -->
      <el-form-item label="" prop="avatar">
        <el-input v-model="form.avatar" placeholder="请输入"></el-input>
      </el-form-item>

      <!--  -->
      <el-form-item label="" prop="nickname">
        <el-input v-model="form.nickname" placeholder="请输入"></el-input>
      </el-form-item>

      <!-- 别名ID -->
      <el-form-item label="别名ID" prop="aliasId">
        <el-input v-model="form.aliasId" placeholder="请输入别名ID"></el-input>
      </el-form-item>

      <!-- 指纹 -->
      <el-form-item label="指纹" prop="fingerprint">
        <el-input v-model="form.fingerprint" placeholder="请输入指纹"></el-input>
      </el-form-item>

      <!-- 注册方式 -->
      <el-form-item label="注册方式" prop="from">
        <el-input v-model="form.from" placeholder="请输入注册方式"></el-input>
      </el-form-item>

      <!-- 设备登录密码 -->
      <el-form-item label="设备登录密码" prop="devicePwd">
        <el-input v-model="form.devicePwd" placeholder="请输入设备登录密码"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" :loading="onSubmit" @click="handleSave">保存</el-button>
        <el-button @click="handleCancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { find, save } from '@/api/member'

export default {
  data() {
    return {
      form: {
        id: undefined,
        mobile: '',
        email: '',
        password: '',
        salt: '',
        authId: '',
        status: 1,
        country: '',
        language: '',
        avatar: '',
        nickname: '',
        aliasId: '',
        fingerprint: '',
        from: '',
        devicePwd: ''
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
     * 查询会员
     */
    findById(id) {
      find(id).then(response => {
        this.form.mobile = response.member.mobile
        this.form.email = response.member.email
        this.form.password = response.member.password
        this.form.salt = response.member.salt
        this.form.authId = response.member.authId
        this.form.status = response.member.status
        this.form.country = response.member.country
        this.form.language = response.member.language
        this.form.avatar = response.member.avatar
        this.form.nickname = response.member.nickname
        this.form.aliasId = response.member.aliasId
        this.form.fingerprint = response.member.fingerprint
        this.form.from = response.member.from
        this.form.devicePwd = response.member.devicePwd
      })
    },

    /**
     * 保存会员
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
