'use strict';

var webpack = require('webpack');
var path = require('path');

module.exports = {
    entry: [
        './vendor.js'
    ],
    output: {
        path: __dirname,
        publicPath: __dirname,
        filename: 'npmdeps-bundle.js'
    }
};

