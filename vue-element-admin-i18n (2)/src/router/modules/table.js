/** When your routing table is too long, you can split it into small modules **/

import Layout from '@/layout'

const tableRouter = {
  path: '/table',
  component: Layout,
  redirect: '/table/complex-table',
  name: 'Table',
  hidden:true,
  meta: {
    title: 'Table',
    icon: 'table'
  },
  children: [

    {
      path: 'taobao',
      component: () => import('@/views/table/taobao'),
      name: 'taobao',
      meta: { title: '淘宝数据列表' },
	  hidden:true,
    }, {
      path: 'jingdong',
      component: () => import('@/views/table/jingdong'),
      name: 'jingdong',
      meta: { title: '京东数据列表' },
	  hidden:true,
    },{
      path: 'tianmao',
      component: () => import('@/views/table/tianmao'),
      name: 'tianmao',
      meta: { title: '天猫数据列表' },
	  hidden:true,
    },{
      path: 'suningyigou',
      component: () => import('@/views/table/suningyigou'),
      name: 'suningyigou',
      meta: { title: '苏宁易购数据列表' },
	  hidden:true,
    },
   {
      path: 'dangdang',
      component: () => import('@/views/table/dangdang'),
      name: 'dangdang',
      meta: { title: '当当网数据列表' },
	  hidden:true,
    },{
      path: 'weipinhui',
      component: () => import('@/views/table/weipinhui'),
      name: 'weipinhui',
      meta: { title: '唯品会数据列表' },
	  hidden:true,
    },{
      path: 'yamaxun',
      component: () => import('@/views/table/yamaxun'),
      name: 'yamaxun',
      meta: { title: '亚马逊数据列表' },
	  hidden:true,
    },{
      path: 'huicong',
      component: () => import('@/views/table/huicong'),
      name: 'huicong',
      meta: { title: '慧聪网数据列表' },
	  hidden:true,
    },
  ]
}
export default tableRouter
