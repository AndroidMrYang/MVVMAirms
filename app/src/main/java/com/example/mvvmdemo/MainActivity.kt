package com.example.mvvmdemo

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmdemo.adapter.HomeListAdapter
import com.example.mvvmdemo.databinding.ActivityMainBinding
import com.example.mvvmdemo.entity.BannerBean
import com.example.mvvmdemo.impl.GlideImageLoader
import com.example.mvvmdemo.vm.MainViewModel
import com.yangk.mvvm.base.BaseActivity
import com.youth.banner.Banner

/**
 *   @auther : Yangk
 *   time   : 2021/11/06
 *  不使用Databinging,结合BRVAH
 */
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    private val mAdapter by lazy { HomeListAdapter() }
    private var page: Int = 0
    private lateinit var banner: Banner<BannerBean, GlideImageLoader>

    override fun initView(savedInstanceState: Bundle?) {
        /**
         * 初始化数据
         * */
        with(mBinding.rvHome) {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
            //banner
            banner = Banner(context)
            banner.minimumWidth = MATCH_PARENT
            banner.layoutParams =
                ViewGroup.LayoutParams(MATCH_PARENT, resources.getDimension(R.dimen.dp_120).toInt())
            banner.adapter = GlideImageLoader()
        }
        /**
         * 适配器设置
         * */
        mAdapter.apply {
            addHeaderView(banner)
            /**
             * BRVAH是设置下来刷新监听
             * */
            loadMoreModule.setOnLoadMoreListener(this@MainActivity::loadMore)
            setOnItemClickListener { adapter, _, position ->
                /* val item = adapter.data[position] as ArticlesBean
                 ToastUtils.showShort("${item.link}")*/
                //跳转页面
                startActivity(Intent(this@MainActivity, MainActivity2::class.java))
            }
        }
        /**
         * 下拉刷新监听
         * */
        mBinding.srlHome.setOnRefreshListener {
            dropDownRefresh()
        }
    }

    override fun initData() {
        /**
         *
         * livbeData设置监听回调
         * */
        viewModel.run {
            /**
             * 轮播图数据变化
             * */
            getBanner().observe(this@MainActivity, {
                banner.setDatas(it)
            })
            /**
             * adapter数据源变化
             * */
            getHomeList(page).observe(this@MainActivity, {
                if (mBinding.srlHome.isRefreshing) mBinding.srlHome.isRefreshing = false
                it?.let {
                    if (it.data.curPage == 1) mAdapter.setNewInstance(it.data.datas)
                    else mAdapter.addData(it.data.datas)
                    if (it.data.curPage == it.data.pageCount) mAdapter.loadMoreModule.loadMoreEnd()
                    else mAdapter.loadMoreModule.loadMoreComplete()
                    page = it.data.curPage
                }
            })
        }
    }


    /**
     * 下拉刷新
     */
    private fun dropDownRefresh() {
        page = 0
        mBinding.srlHome.isRefreshing = true
        viewModel.getHomeList(page)
        viewModel.getBanner()
    }

    /**
     * 加载更多
     */
    private fun loadMore() {
        viewModel.getHomeList(page + 1)
    }
}
