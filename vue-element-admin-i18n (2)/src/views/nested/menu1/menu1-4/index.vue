<template>
	
  <div class="app-container" >
    <div class="filter-container">
      <el-input v-model="listQuery.id" :placeholder="$t('table.goodsId')" style="width: 43.75rem;" class="filter-item" @keyup.enter.native="handleFilter" />
      <!-- <el-select v-model="listQuery.page" :placeholder="$t('')" clearable style="width: 180px" class="filter-item">
        <el-option v-for="i in 100" :key="i" :label="i" :value="i" />
      </el-select> -->

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
	}, -->
      <el-table-column :label="$t('ID')" prop="id"  align="center"min-width="4%" :class-name="getSortClass('id')">
        <template slot-scope="{row}">
          <span>{{ row.id }}</span>
        </template>
      </el-table-column>
          <el-table-column :label="$t('table.goodsId')" min-width="14%" align="center">
                  <template slot-scope="{row}">
                    <span>{{ row.goodsId }}</span>
                  </template>
                </el-table-column>
             <el-table-column :label="$t('table.url')" min-width="15%" align="center">
                  <template slot-scope="{row}">
                    <span @click="dump(row.url)">{{ row.url }}</span>
                  </template>
                </el-table-column>
             <el-table-column :label="$t('table.goodsTitle')" min-width="14%" align="center">
                  <template slot-scope="{row}">
                    <span>{{ row.goodsTitle }}</span>
                  </template>
                </el-table-column>
             <el-table-column :label="$t('table.subtitle')" min-width="11%" align="center">
                  <template slot-scope="{row}">
                    <span>{{ row.subtitle }}</span>
                  </template>
                </el-table-column>
             <el-table-column :label="$t('table.price')" min-width="10%" align="center">
                  <template slot-scope="{row}">
                    <span>{{ row.price }}</span>
                  </template>
                </el-table-column>
             <el-table-column :label="$t('table.storeName')" min-width="8%" align="center">
                  <template slot-scope="{row}">
                    <span>{{ row.storeName }}</span>
                  </template>
                </el-table-column>
             <el-table-column :label="$t('table.babyBescription')" min-width="8%" align="center">
                  <template slot-scope="{row}">
                    <span>{{ row.babyBescription }}</span>
                  </template>
                </el-table-column>
             <el-table-column :label="$t('table.service')" min-width="8%" align="center">
                  <template slot-scope="{row}">
                    <span>{{ row.service }}</span>
                  </template>
                </el-table-column>
             <el-table-column :label="$t('table.logisticsService')" min-width="8%" align="center">
                  <template slot-scope="{row}">
                    <span>{{ row.logisticsService }}</span>
                  </template>
                </el-table-column>

    </el-table>
  </div>

</template>

<script>
import { fetchDetails } from '@/api/article'
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
      list:[] ,
      total: 0,
      listLoading: false,
      listQuery: {
        // page: 1,
       id:'600541836815',
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
      fetchDetails(this.listQuery).then(response => {
		if(this.list!=""){
			 // alert(JSON.stringify(response.data.items[i].id))
			  var id =this.list[this.list.length-1].id
		}
		for(var i=0;i<response.data.items.length;i++){
			
			 if(this.list.length>99){
			response.data.items[i].id=id+response.data.items[i].id
		
			 }
			this.list.push(response.data.items[i])
			}
		
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
        const tHeader = ['ID', '商品ID', '商品链接', '标题', '副标题',  '价格',  '店铺名称', '宝贝描述', '卖家服务', '物流服务']
        const filterVal = ['id', 'goodsId', 'url', 'goodsTitle', 'subtitle', 'price', 'stroeName', 'babyBescription', 'service', 'logisticsService']
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

