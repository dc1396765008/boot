/** When your routing table is too long, you can split it into small modules **/

import Layout from '@/layout'

const nestedRouter = {
	path: '/nested',
	component: Layout,
	redirect: '/nested/menu1/menu1-1',
	name: 'Nested',
	meta: {
		title: 'nested',
		icon: 'nested'
	},
	children: [{
			path: 'menu1',
			component: () => import('@/views/nested/menu1/index'), // Parent router-view
			name: '淘宝',
			meta: {
				title: 'menu1'
			},
			redirect: '/nested/menu1/menu1-1',
			children: [{
					path: 'menu1-1',
					component: () => import('@/views/nested/menu1/menu1-1'),
					name: 'menu1-1',
					meta: {
						title: 'menu1-1'
					}
				},
				
			]
		},
		{
			path: 'menu2',
			component: () => import('@/views/nested/menu2/index'), // Parent router-view
			name: '京东',
			meta: {
				title: 'menu2'
			},
			redirect: '/nested/menu2/menu2-1',
			children: [{
					path: 'menu2-1',
					component: () => import('@/views/nested/menu2/menu2-1'),
					name: 'menu2-1',
					meta: {
						title: 'menu2-1'
					}
				}
			]
		},
		{
			path: 'menu3',
			component: () => import('@/views/nested/menu3/index'), // Parent router-view
			name: '天猫',
			meta: {
				title: 'menu3'
			},
			redirect: '/nested/menu3/menu3-1',
			children: [{
					path: 'menu3-1',
					component: () => import('@/views/nested/menu3/menu3-1'),
					name: 'menu3-1',
					meta: {
						title: 'menu3-1'
					}
				}
			]
		},{
			path: 'menu4',
			component: () => import('@/views/nested/menu4/index'), // Parent router-view
			name: '苏宁易购',
			meta: {
				title: 'menu4'
			},
			redirect: '/nested/menu4/menu4-1',
			children: [{
					path: 'menu4-1',
					component: () => import('@/views/nested/menu4/menu4-1'),
					name: 'menu4-1',
					meta: {
						title: 'menu4-1'
					}
				}
			]
		},{
			path: 'menu5',
			component: () => import('@/views/nested/menu5/index'), // Parent router-view
			name: '当当网',
			meta: {
				title: 'menu5'
			},
			redirect: '/nested/menu5/menu5-1',
			children: [{
					path: 'menu5-1',
					component: () => import('@/views/nested/menu5/menu5-1'),
					name: 'menu5-1',
					meta: {
						title: 'menu5-1'
					}
				}
			]
		},{
			path: 'menu6',
			component: () => import('@/views/nested/menu6/index'), // Parent router-view
			name: '唯品会',
			meta: {
				title: 'menu6'
			},
			redirect: '/nested/menu6/menu6-1',
			children: [{
					path: 'menu6-1',
					component: () => import('@/views/nested/menu6/menu6-1'),
					name: 'menu6-1',
					meta: {
						title: 'menu6-1'
					}
				}
			]
		},{
			path: 'menu7',
			component: () => import('@/views/nested/menu7/index'), // Parent router-view
			name: '亚马逊',
			meta: {
				title: 'menu7'
			},
			redirect: '/nested/menu7/menu7-1',
			children: [{
					path: 'menu7-1',
					component: () => import('@/views/nested/menu7/menu7-1'),
					name: 'menu7-1',
					meta: {
						title: 'menu7-1'
					}
				}
			]
		},{
			path: 'menu8',
			component: () => import('@/views/nested/menu8/index'), // Parent router-view
			name: '慧聪网',
			meta: {
				title: 'menu8'
			},
			redirect: '/nested/menu8/menu8-1',
			children: [{
					path: 'menu8-1',
					component: () => import('@/views/nested/menu8/menu8-1'),
					name: 'menu8-1',
					meta: {
						title: 'menu8-1'
					}
				}
			]
		}
	]
}

export default nestedRouter
