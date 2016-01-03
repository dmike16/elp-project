module.exports = function(grunt){
  grunt.initConfig({
    concat: {
      options:{
        separator: ';',
      },
      dist:{
        src:['app.js','pattern.js'],
        dest: 'build.js',
      }
    }
  });

  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.registerTask('default',['concat']);
};
