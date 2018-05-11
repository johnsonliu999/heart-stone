var path = require('path');

module.exports = {
    entry: './app.js',
    devtool: 'sourcemaps',
    // cache: true,
    output: {
        path: __dirname,
        filename: '../resources/static/built/bundle.js'
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader'
                }
            }
        ]
    }
};