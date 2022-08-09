// 项目在发布时需要用到的 babel 插件数组
const proPlugins = [];
// 如果当前是测试环境或者是生产环境，则使用去掉 console 的插件
if (process.env.NODE_ENV === 'alpha' || process.env.NODE_ENV === 'production') {
    proPlugins.push('transform-remove-console');
    //proPlugins.push('dynamic-import-node');
}
module.exports = {
    plugins: [
        ...proPlugins
    ],
    presets: [
        // https://github.com/vuejs/vue-cli/tree/master/packages/@vue/babel-preset-app
        '@vue/cli-plugin-babel/preset'
    ],
    'env': {
        'development': {
            // babel-plugin-dynamic-import-node plugin only does one thing by converting all import() to require().
            // This plugin can significantly increase the speed of hot updates, when you have a large number of pages.
            // https://panjiachen.github.io/vue-element-admin-site/guide/advanced/lazy-loading.html
            'plugins': ['dynamic-import-node']
        }
    }
}
