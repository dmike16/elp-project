module.exports = function(grunt){
	//Configure grunt Tasks
	grunt.initConfig({
		less:{
			snapshot:{
				options:{
					paths: "css/import",
				},
				files:{
					"css/build.css":"css/main.less"
				}
			}
		}
	});

	grunt.loadNpmTasks('grunt-contrib-less');
	grunt.registerTask('default',['less']);
}