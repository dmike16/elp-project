const helper = require('./helper');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CleanWebpackPlugin = require('clean-webpack-plugin');

module.exports = {
  entry:{
    'polyfills': './src/polyfills.ts',
    'vendor': './src/vendor.ts',
    'app': './src/main.ts'
  },

  resolve:{
    extensions: ['.ts','.js']
  },

  module:{
    rules:[
      {
        test: /\.ts$/,
        use:[
          {
            loader: 'awesome-typescript-loader',
            options:{configFileName: helper.root('src','tsconfig.json')}
          },
          'angular2-template-loader'
        ]
      },
      {
        test: /\.html$/,
        use: ['html-loader']
      },
      {
        test: /\.(png|jpe?g|gif|svg|woff|woff2|ttf|eot|ico)$/,
        use: ['file-loader?name=assets/[name].[hash].[ext]']
      },
      {
        test: /\.css$/,
        exclude: helper.root('src','app'),
        use: ExtractTextPlugin.extract({
          fallback: 'style-loader',
          use: ['css-loader?sourceMap']
        })
      },
      {
        test: /.css$/,
        include: helper.root('src','app'),
        use: ['raw-loader']
      }
    ]
  },

  plugins:[
    new CleanWebpackPlugin(['dist']),

    new webpack.ContextReplacementPlugin(
      /angular(\\|\/)core(\\|\/)@angular/,
      helper.root('./src'),
      {}
    ),

    new webpack.optimize.CommonsChunkPlugin({
      name:['app','vendor','polyfills']
    }),

    new HtmlWebpackPlugin({
      template: 'src/index.html'
    })
  ]
};
