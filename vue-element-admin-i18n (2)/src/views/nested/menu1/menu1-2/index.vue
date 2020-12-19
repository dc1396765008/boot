<template>
  <div class="app-container" >
    <div class="filter-container">
<!--      <el-input v-model="listQuery.title" :placeholder="$t('table.title')" style="width: 400px;" class="filter-item" @keyup.enter.native="handleFilter" /> -->
    <el-input v-model="listQuery.store"  :placeholder="$t('table.title')" style="width: 200px;" class="filter-item"  />
      <el-select v-model="listQuery.page" :placeholder="$t('')" clearable style="width: 400px" class="filter-item">
        <el-option v-for="i in 100" :key="i" :label="i" :value="i" />
      </el-select>

      <el-button v-waves class="filter-item" type="primary" style="width: 200px;margin-left: 50px;" icon="el-icon-search" @click="handleFilter">
        {{ $t('table.search') }}
      </el-button>

      <el-button v-waves :loading="downloadLoading" style="width: 200px;" class="filter-item" type="primary" icon="el-icon-download" @click="handleDownload">
        {{ $t('table.export') }}
      </el-button>

    </div>

    <el-table
     
      v-loading="listLoading"
      :data="list"
      border
      style="width: 100%;"
      
    >
<!-- 	table: {
	  dynamicTips1: '固定表头, 按照表头顺序排序',
	  dynamicTips2: '不固定表头, 按照点击顺序排序',
	  dragTips1: '默认顺序',
	  dragTips2: '拖拽后顺序',
	  title: '商品名称',
	  importance: '重要性',
	  type: '类型',
	  remark: '点评',
	  search: '开始爬取',
	  add: '添加',
	  export: '导出',
	  reviewer: '审核人',
	  id: '序号',
	  date: '时间',
	  author: '作者',
	  readings: '阅读数',
	  status: '状态',
	  actions: '操作',
	  edit: '编辑',
	  publish: '发布',
	  draft: '草稿',
	  delete: '删除',
	  cancel: '取 消',
	  confirm: '确 定'
	  storeName:店铺名称,
	  locaTion:'地理位置',
	  goodsName:'产品名称',
	  price:'产品价格',
	  number:'付款人数',
	  url:'商品链接',
	  data:'当前时间',
	  
	  classification:"商品分类",
	  sold:'活动已售',
	  preferential:'特价'
	  pageUrl:'页面网址',
	  goodsId:'商品ID',
	  goodsTitle:'标题'
	  goodsDetails:'商品详情',
	  address:'发货地址',
	  commentNum:'评论数',
	  dealNum:'交易量',
	  storeNum:'仓库数',
	}, -->
      <el-table-column :label="$t('ID')" prop="id"  align="center" min-width="6%" :class-name="getSortClass('id')">
        <template slot-scope="{row}">
          <span>{{ row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column :label="$t('table.sold')" min-width="8%" align="center">
        <template slot-scope="{row}">
        <span>{{ row.sold}}</span>
        </template>
      </el-table-column>
      <el-table-column :label="$t('table.url')" min-width="18%" align="center">
        <template slot-scope="{row}">
          <span @click="dump(row.url)">{{ row.url }}</span>
        </template>
      </el-table-column>
 
      </el-table-column>
      <el-table-column :label="$t('table.preferential')" min-width="8%" align="center">
        <template slot-scope="{row}">
        <span>{{ row.preferential }}</span>
        </template>
      </el-table-column>
      <el-table-column :label="$t('table.price')" align="center" min-width="10%">
        <template slot-scope="{row}">
      <span>{{ row.price }}</span>
        </template>
      </el-table-column>
      <el-table-column :label="$t('table.date')" class-name="status-col" min-width="10%">
        <template slot-scope="{row}">
       <span>{{ row.date}}</span>
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column :label="$t('table.pageUrl')" align="center" min-width="18%" class-name="small-padding fixed-width">
       <template slot-scope="{row}">
		<span @click="dump(row.pageUrl)">{{ row.pageUrl }}</span>
         </el-tag>
       </template>
      </el-table-column>
	  <el-table-column :label="$t('table.goodsTitle')" align="center" min-width="8%" class-name="small-padding fixed-width">
	   <template slot-scope="{row}">
	  		<span>{{ row.goodsTitle }}</span>
	     </el-tag>
	   </template>
	  </el-table-column>
	  <el-table-column :label="$t('table.goodsDetails')" align="center" min-width="14%" class-name="small-padding fixed-width">
	   <template slot-scope="{row}">
	  		<span>{{ row.goodsDetails }}</span>
	     </el-tag>
	   </template>
	  </el-table-column>
    </el-table>


  </div>
</template>

<script>
import { fetchDay } from '@/api/article'
import waves from '@/directive/waves' // waves directive
import { parseTime } from '@/utils'
import Pagination from '@/components/Pagination' // secondary package based on el-pagination

const calendarTypeOptions = [
  
]

// arr to obj, such as { CN : "China", US : "USA" }
const calendarTypeKeyValue = calendarTypeOptions.reduce((acc, cur) => {
  acc[cur.key] = cur.display_name
  return acc
}, {})

export default {
  name: 'ComplexTable',
  components: { Pagination },
  directives: { waves },
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'info',
        deleted: 'danger'
      }
      return statusMap[status]
    },
    typeFilter(type) {
      return calendarTypeKeyValue[type]
    }
  },
  data() {
    return {
      tableKey: 0,
      list: null,
      total: 0,
      listLoading: false,
      listQuery: {
        page: 1,
		store:'女装',
      },
     
      calendarTypeOptions,
    
      downloadLoading: false
    }
  },
  created() {
    // this.getList()
  },
  methods: {  
	  dump(url){
	  		  window.open(url);
	  },
    getList() {
      this.listLoading = true
      fetchDay(this.listQuery).then(response => {
        this.list = response.data.items
        this.total = response.data.total

        // Just to simulate the time of the request
        setTimeout(() => {
          this.listLoading = false
        }, 1.5 * 1000)
      })
    },
    handleFilter() {
      this.getList()
    },

    handleDownload() {
      this.downloadLoading = true
	  
      import('@/vendor/Export2Excel').then(excel => {
	
        const tHeader = ['id',  '活动已售', '商品链接', '特价',"商品价格","当前时间","页面网址",'标题','商品详情']
        const filterVal = ['id',  'sold', 'url', 'preferential','price','date','pageUrl','goodsTitle','goodsDetails']
        const data = this.formatJson(filterVal)
	
        excel.export_json_to_excel({
          header: tHeader,
          data,
          filename: 'table-list'
        })
      this.downloadLoading = false
      })
    },
    formatJson(filterVal) {
      return this.list.map(v => filterVal.map(j => {
        if (j === 'timestamp') {
          return parseTime(v[j])
        } else {
          return v[j]
        }
      }))
    },
    getSortClass: function(key) {
      const sort = this.listQuery.sort
      return sort === `+${key}` ? 'ascending' : 'descending'
    }
  }
}
</script>

