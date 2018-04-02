<template>
  <div class="app-container app-edit">
    <el-form class="small-space" :model="form" :rules="rules" ref="form" label-position="right" label-width="120px" style="width: 700px;">

      <!-- 设备唯一ID -->
      <el-form-item :label="$t('deviceKey.qniqueId')" prop="deviceUniqueId">
        <el-input v-model="form.deviceUniqueId" :placeholder="$t('deviceKey.inputQniqueId')"></el-input>
      </el-form-item>

      <!-- 设备唯一KEY -->
      <el-form-item :label="$t('deviceKey.key')" prop="deviceKey">
        <el-input v-model="form.deviceKey" :placeholder="$t('deviceKey.inputKey')"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" :loading="onSubmit" @click="handleSave">保存</el-button>
        <el-button @click="handleCancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { find, save } from '@/api/device/key'

export default {
  data() {
    return {
      form: {
        id: undefined,
        deviceUniqueId: '',
        deviceKey: '',
        deviceId: ''
      },

      onSubmit: false,

      // 表单验证规则
      rules: {
        deviceUniqueId: [
          { required: true, message: this.$t('deviceKey.inputQniqueId'), trigger: 'blur' },
          { max: 50, message: this.$t('deviceKey.qniqueIdMaxlength'), trigger: 'blur' }
        ],
        deviceKey: [
          { required: true, message: this.$t('deviceKey.inputKey'), trigger: 'blur' },
          { max: 50, message: this.$t('deviceKey.keyMaxlength'), trigger: 'blur' }
        ]/* ,
        chipType: [
          { required: true, message: '请选择设备类型', trigger: 'blur' }
        ],
        type: [
          { required: true, message: '请选择升级状态', trigger: 'blur' }
        ] */
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
     * 查询设备唯一序列号
     */
    findById(id) {
      find(id).then(response => {
        this.form.deviceUniqueId = response.deviceKey.deviceUniqueId
        this.form.deviceKey = response.deviceKey.deviceKey
        this.form.deviceId = response.deviceKey.deviceId
      })
    },

    /**
     * 保存设备唯一序列号
     */
    handleSave() {
      this.$refs.form.validate(valid => {
        if (!valid) {
          return false
        }

        this.onSubmit = true
        save(this.form).then(response => {
          console.log('err_code:' + response.err_code)
          console.log('err_msg:' + response.err_msg)
          if (response.err_code !== 0) {
            this.$message.warning({ message: response.err_msg, center: true })
          } else {
            this.$router.go(-1)
          }
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
