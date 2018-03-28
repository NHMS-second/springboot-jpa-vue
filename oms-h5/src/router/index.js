import Vue from 'vue'
import Router from 'vue-router'
import storage from '@/utils/storage'
const _import = require('./_import_' + process.env.NODE_ENV)
// in development env not use Lazy Loading,because Lazy Loading too many pages will cause webpack hot update too slow.so only in production use Lazy Loading

Vue.use(Router)

/* layout */
import Layout from '../views/layout/Layout'

/**
* icon : the icon show in the sidebar
* hidden : if `hidden:true` will not show in the sidebar
* redirect : if `redirect:noredirect` will no redirct in the levelbar
* noDropdown : if `noDropdown:true` will has no submenu
* meta : { role: ['admin'] }  will control the page role
**/
export const constantRouterMap = [
  { path: '/login', component: _import('login/index'), hidden: true },
  { path: '/authredirect', component: _import('login/authredirect'), hidden: true },
  { path: '/404', component: _import('errorPage/404'), hidden: true },
  { path: '/401', component: _import('errorPage/401'), hidden: true },

  // 隐藏菜单
  {
    path: '/',
    component: Layout,
    icon: 'people',
    noDropdown: true,
    hidden: true,
    name: '',
    children: [
      { path: '/sys/admin/edit', component: _import('sys/admin/edit'), name: '编辑管理员', hidden: true },
      { path: '/sys/menu/edit', component: _import('sys/menu/edit'), name: '编辑菜单', hidden: true },
      { path: '/sys/role/edit', component: _import('sys/role/edit'), name: '编辑角色', hidden: true },
      { path: '/sys/permission/index', component: _import('sys/permission/index'), name: '权限点', hidden: true },
      { path: '/questionnaire/edit', component: _import('questionnaire/edit'), hidden: true, name: 'message.add' },
      { path: '/questionnaire/statistics', component: _import('questionnaire/statistics'), hidden: true, name: 'message.add' },
      { path: '/firmware/edit', component: _import('firmware/edit'), hidden: true, name: 'firmware.add' }
    ]
  }
]
const menus = storage.get('menus')
if (menus) {
  menus.forEach((item) => {
    const menu = {
      path: '',
      component: Layout,
      redirect: 'noredirect',
      icon: item.icon,
      name: item.name,
      children: []
    }
    item.childList.forEach((child) => {
      const childMenu = {
        path: '/' + child.url,
        name: child.name,
        component: _import(child.url)
      }
      menu.children.push(childMenu)
    })
    constantRouterMap.push(menu)
  })
}

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})

export const asyncRouterMap = []

// export const asyncRouterMap = [
//   {
//     path: '/permission',
//     component: Layout,
//     redirect: '/permission/index',
//     name: '权限测试',
//     icon: 'lock',
//     meta: { role: ['admin'] },
//     noDropdown: true,
//     children: [{ path: 'index', component: _import('permission/index'), name: '权限测试页', meta: { role: ['admin'] }}]
//   },
//   {
//     path: '/icon',
//     component: Layout,
//     icon: 'icon',
//     noDropdown: true,
//     children: [{ path: 'index', component: _import('svg-icons/index'), name: 'icons' }]
//   },
//   {
//     path: '/components',
//     component: Layout,
//     redirect: '/components/index',
//     name: '组件',
//     icon: 'component',
//     children: [
//       { path: 'index', component: _import('components/index'), name: '介绍 ' },
//       { path: 'tinymce', component: _import('components/tinymce'), name: '富文本编辑器' },
//       { path: 'markdown', component: _import('components/markdown'), name: 'Markdown' },
//       { path: 'jsoneditor', component: _import('components/jsonEditor'), name: 'JSON编辑器' },
//       { path: 'dndlist', component: _import('components/dndList'), name: '列表拖拽' },
//       { path: 'splitpane', component: _import('components/splitpane'), name: 'SplitPane' },
//       { path: 'avatarupload', component: _import('components/avatarUpload'), name: '头像上传' },
//       { path: 'dropzone', component: _import('components/dropzone'), name: 'Dropzone' },
//       { path: 'sticky', component: _import('components/sticky'), name: 'Sticky' },
//       { path: 'countto', component: _import('components/countTo'), name: 'CountTo' },
//       { path: 'mixin', component: _import('components/mixin'), name: '小组件' },
//       { path: 'backtotop', component: _import('components/backToTop'), name: '返回顶部' }
//     ]
//   },
//   {
//     path: '/charts',
//     component: Layout,
//     redirect: '/charts/index',
//     name: '图表',
//     icon: 'chart',
//     children: [
//       { path: 'index', component: _import('charts/index'), name: '介绍' },
//       { path: 'keyboard', component: _import('charts/keyboard'), name: '键盘图表' },
//       { path: 'keyboard2', component: _import('charts/keyboard2'), name: '键盘图表2' },
//       { path: 'line', component: _import('charts/line'), name: '折线图' },
//       { path: 'mixchart', component: _import('charts/mixChart'), name: '混合图表' }
//     ]
//   },
//   {
//     path: '/example',
//     component: Layout,
//     redirect: 'noredirect',
//     name: '综合实例',
//     icon: 'example',
//     children: [
//       {
//         path: '/example/table',
//         component: _import('example/table/index'),
//         redirect: '/example/table/table',
//         name: 'Table',
//         icon: 'table',
//         children: [
//           { path: 'dynamictable', component: _import('example/table/dynamictable/index'), name: '动态table' },
//           { path: 'dragtable', component: _import('example/table/dragTable'), name: '拖拽table' },
//           { path: 'inline_edit_table', component: _import('example/table/inlineEditTable'), name: 'table内编辑' },
//           { path: 'table', component: _import('example/table/table'), name: '综合table' }
//         ]
//       },
//       { path: 'form/edit', icon: 'form', component: _import('example/form'), name: '编辑Form', meta: { isEdit: true }},
//       { path: 'form/create', icon: 'form', component: _import('example/form'), name: '创建Form' },
//       { path: 'tab/index', icon: 'tab', component: _import('example/tab/index'), name: 'Tab' }
//     ]
//   },
//   {
//     path: '/error',
//     component: Layout,
//     redirect: 'noredirect',
//     name: '错误页面',
//     icon: '404',
//     children: [
//       { path: '401', component: _import('errorPage/401'), name: '401' },
//       { path: '404', component: _import('errorPage/404'), name: '404' }
//     ]
//   },
//   {
//     path: '/errlog',
//     component: Layout,
//     redirect: 'noredirect',
//     name: 'errlog',
//     icon: 'bug',
//     noDropdown: true,
//     children: [{ path: 'log', component: _import('errlog/index'), name: '错误日志' }]
//   },
//   {
//     path: '/excel',
//     component: Layout,
//     redirect: '/excel/download',
//     name: 'excel',
//     icon: 'excel',
//     children: [
//       { path: 'download', component: _import('excel/index'), name: '导出excel' },
//       { path: 'download2', component: _import('excel/selectExcel'), name: '导出已选择项' },
//       { path: 'upload', component: _import('excel/uploadExcel'), name: 'upload excel' }
//     ]
//   },
//   {
//     path: '/theme',
//     component: Layout,
//     redirect: 'noredirect',
//     name: 'theme',
//     icon: 'theme',
//     noDropdown: true,
//     children: [{ path: 'index', component: _import('theme/index'), name: '换肤' }]
//   },

//   { path: '*', redirect: '/404', hidden: true }
// ]