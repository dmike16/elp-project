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
		},
		concat:{
			options:{
				separator: ';'
			},
			dist:{
				src: ['js/small-cookie.js','js/store.js'],
				dest: 'js/build.js'
			}
		}
	});

	grunt.loadNpmTasks('grunt-contrib-less');
	grunt.loadNpmTasks('grunt-contrib-concat');
	grunt.registerTask('default',['less']);
}