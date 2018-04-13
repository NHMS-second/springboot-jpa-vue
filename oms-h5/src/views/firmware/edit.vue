<template>
  <div class="app-container app-edit">
    <el-form class="small-space" :model="form" :rules="rules" ref="form" label-position="right" label-width="120px" style="width: 700px;">

      <!-- 版本号 -->
      <el-form-item :label="$t('firmware.revision')" prop="revision">
        <el-input v-model="form.revision" :placeholder="$t('firmware.revision')"></el-input>
      </el-form-item>


      <el-form-item :label="$t('firmware.upload')">
        <el-upload
        class="upload-demo"
        action="/api/uploadFiles"
        :limit="1"
        :before-upload="beforeUpload"
        :on-success="handleSuccess">
        <el-button size="small" type="primary">{{$t('firmware.clickUpload')}}</el-button>
        <div slot="tip" class="el-upload__tip">{{$t('firmware.onlyChip')}}</div>
      </el-upload>

        <!-- <el-upload action="/api/uploadFiles" list-type="picture-card" 
        :on-preview="handlePictureCardPreview" 
        :on-remove="handleRemove">
          <i class="el-icon-plus"></i>
        </el-upload>
        <el-dialog v-model="dialogVisible" size="tiny">
          <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog> -->
      </el-form-item>


      <!-- 设备类型 -->
      <!-- <el-form-item :label="$t('firmware.chipType')" prop="chipType">
        <el-select v-model="form.chipType" style="width: 120px" class="filter-item" clearable :placeholder="$t('firmware.chipType')">
          <el-option v-for="item in chip.type"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item> -->


      <!-- 升级状态 -->
      <el-form-item :label="$t('firmware.type')" prop="type">
        <!-- <el-input v-model="form.type" placeholder="请输入升级状态"></el-input> -->
           <el-select v-model="form.type" style="width: 120px" class="filter-item" :placeholder="$t('firmware.type')">
      <el-option v-for="item in type.options"
        :key="item.value"
        :label="item.label"
        :value="item.value">
      </el-option>
    </el-select>
        
      </el-form-item>

      <el-form-item>
        <el-button type="primary" :loading="onSubmit" @click="handleSave">{{$t('message.save')}}</el-button>
        <el-button @click="handleCancel">{{$t('message.cancel')}}</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { find, save } from '@/api//firmware'

export default {
  data() {
    return {
      dialogImageUrl: '',
      dialogVisible: false,
      form: {
        id: undefined,
        revision: '',
        name: '',
        fileName: '',
        chipType: '',
        bytes: '',
        type: 0
      },

      chip: {
        type: [
          { value: 1, label: 'muc' },
          { value: 2, label: 'dsp' }
        ]
      },
      type: {
        options: [
          { value: 0, label: this.$t('firmware.noforce') },
          { value: 1, label: this.$t('firmware.force') }
        ]
      },

      onSubmit: false,

      // 表单验证规则
      rules: {
        revision: [
          { required: true, message: this.$t('firmware.inputRevision'), trigger: 'blur' },
          { max: 50, message: this.$t('firmware.revisionMaxlength'), trigger: 'blur' }
        ],
        name: [
          { required: true, message: this.$t('firmware.inputName'), trigger: 'blur' },
          { max: 50, message: this.$t('firmware.nameMaxlength'), trigger: 'blur' }
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
    beforeUpload(file) {
      const max40M = file.size / 1024 / 1024 > 40
      if (max40M) {
        this.$message.warning({ message: this.$t('firmware.max40M'), center: true })
        return false
      }
    },
    /**
     * 查询设备固件
     */
    findById(id) {
      find(id).then(response => {
        this.form.revision = response.firmware.revision
        this.form.name = response.firmware.name
        this.form.fileName = response.firmware.fileName
        // this.form.chipType = response.firmware.chipType
        this.form.bytes = response.firmware.bytes
        this.form.type = response.firmware.type
      })
    },
    handleSuccess(response, file, fileList) {
      var fileName = response.fileName
      console.log('fileName:' + fileName)
      this.form.fileName = response.fileName
      this.form.name = response.name
      this.form.bytes = response.bytes
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url
      this.dialogVisible = true
    },
    /**
    /**
     * 保存设备固件
     */
    handleSave() {
      this.$refs.form.validate(valid => {
        if (!valid) {
          return false
        }
        if (!this.form.fileName) {
          this.$message.warning({ message: this.$t('firmware.needUpload'), center: true })
          return
        }
        this.onSubmit = true
        save(this.form).then(response => {
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
