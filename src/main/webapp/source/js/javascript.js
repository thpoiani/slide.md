module.exports = function(grunt) {

  grunt.constants = {
    banner: '/*! <%= pkg.name %> <%= pkg.version %> | <%= pkg.author %> */\n' +
            '/*! <%= pkg.repository.url %>                 */\n',

    js: {
      development: './js/',
      production: '../js/'
    },

    css: {
      development: './css/',
      production: '../css/'
    },

    normalize: './bower_components/normalize.css/normalize.css'
  }

  grunt.loadTasks('grunt_tasks');
  grunt.loadNpmTasks('grunt-contrib-clean');
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-contrib-cssmin');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-compass');

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),

    clean: {
      options: {
        force: true
      },
      production: [grunt.constants.css.production, grunt.constants.js.production]
    },

    compass: {
      dist: {
        options: {
          config: 'config.rb'
        }
      }
    },

    copy: {
      js: {
        files: [
          {
            expand: true,
            cwd: grunt.constants.js.development,
            src: ['*.js'],
            dest: grunt.constants.js.production
          }
        ]
      },
      css: {
        files: [
          {
            expand: true,
            cwd: grunt.constants.css.development,
            src: ['*.css'],
            dest: grunt.constants.css.production
          }
        ]
      }
    },

    cssmin: {
      options: {
        report: 'gzip'
      },
      minify: {
        expand: true,
        cwd: grunt.constants.css.development,
        src: ['*.css', '!*.min.css'],
        dest: grunt.constants.css.production
      }
    },

    uglify: {
      options: {
          mangle: false,
          report: 'gzip'
      },
      minify: {
        files: [
          {
            expand: true,
            cwd: grunt.constants.js.development,
            src: ['*.js', '!*.min.js'],
            dest: grunt.constants.js.production,
          }
        ]
      }
    }

  });

  grunt.registerTask('default', ['clean', 'compass', 'normalize-concat', 'copy:js', 'copy:css']);

  grunt.registerTask('deploy', ['clean', 'compass', 'normalize-concat', 'uglify', 'cssmin']);

  grunt.registerTask('dev', ['compass', 'normalize-concat']);

}