<template>
	
  <div class="app-container"  >
    <div class="filter-container">
      <el-input v-model="listQuery.url"  :placeholder="$t('table.title')" style="width: 200px;" class="filter-item" @keyup.enter.native="handleFilter" />
  
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
	}, -->
      <el-table-column :label="$t('ID')"  prop="id"  align="center"  min-width="10%" :class-name="getSortClass('id')" >
        <template slot-scope="{row}"  >
          <span>{{ row.id }}</span>
        </template>
      </el-table-column>
       <el-table-column :label="$t('table.member')" min-width="10%" align="center">
              <template slot-scope="{row}">
                <span>{{ row.member }}</span>
              </template>
            </el-table-column>
         <el-table-column :label="$t('table.level')" min-width="10%" align="center">
              <template slot-scope="{row}">
                <span>{{ row.level }}</span>
              </template>
            </el-table-column>
         <el-table-column :label="$t('table.ratingStars')" min-width="10%" align="center">
              <template slot-scope="{row}">
                <span>{{ row.ratingStars }}</span>
              </template>
            </el-table-column>
         <el-table-column :label="$t('table.commentContent')" min-width="20%" align="center">
              <template slot-scope="{row}">
                <span>{{ row.commentContent }}</span>
              </template>
            </el-table-column>
         <el-table-column :label="$t('table.time')" min-width="10%" align="center">
              <template slot-scope="{row}">
                <span>{{ row.time }}</span>
              </template>
            </el-table-column>
         <el-table-column :label="$t('table.likes')" min-width="10%" align="center">
              <template slot-scope="{row}">
                <span>{{ row.likes }}</span>
              </template>
            </el-table-column>
         <el-table-column :label="$t('table.numberOfComments')" min-width="10%" align="center">
              <template slot-scope="{row}">
                <span>{{ row.numberOfComments }}</span>
              </template>
            </el-table-column>
         <el-table-column :label="$t('table.commodityAttributes')" min-width="10%" align="center">
              <template slot-scope="{row}">
                <span>{{ row.commodityAttributes }}</span>
              </template>
            </el-table-column>
    </el-table>


  </div>

</template>

<script>
import { fetchComment } from '@/api/jd'
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
     url:"https://item.jd.com/41603218628.html"
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
      fetchComment(this.listQuery).then(response => {
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
        const tHeader = ['ID', '会员', '级别', '评价星级', '评价内容', '时间', '点赞数', '评论数', '商品属性']
        const filterVal = ['id', 'member', 'level', 'ratingStars', 'commentContent', 'time', 'likes', 'numberOfComments', 'commodityAttributes']
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

