var webpack = require('webpack');
var path = require('path');

module.exports = {
    entry: './src/App.jsx',
    output: {
        path:  path.resolve(__dirname,"../target"),
        // path:  path.resolve(__dirname,"../src/main/resources/static"),
        filename: 'bundle.js'
    },
    watch: true,
    module: {
        loaders: [
            {
                test: /\.jsx$/,
                exclude: /node_modules/,
                loader: 'babel-loader'
            }
        ]
    },
    resolve: {
        extensions: ['.jsx', '.js', '.json', ]
    }

};