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

    images: {
      development: './img/',
      production: '../img/'
    },

    fonts: {
      development: './fonts/',
      production: '../fonts/'
    },

    ace: {
      development: './bower_components/ace-builds/src-min-noconflict/',
      production: '../js/ace/'
    },

    normalize: './bower_components/normalize.css/normalize.css'
  }

  grunt.loadTasks('grunt_tasks');
  grunt.loadNpmTasks('grunt-contrib-clean');
  grunt.loadNpmTasks('grunt-contrib-compass');
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-contrib-cssmin');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-imagemin');

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),

    clean: {
      options: {
        force: true
      },
      production: [
        grunt.constants.css.production,
        grunt.constants.js.production,
        grunt.constants.images.production,
        grunt.constants.fonts.production
      ]
    },

    compass: {
      clean: {
        options: {
          clean: true,
          config: 'config.rb'
        }
      },
      compile: {
        options: {
          force: true,
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
            src: ['**/*'],
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
      },
      images: {
        files: [
          {
            expand: true,
            cwd: grunt.constants.images.development,
            src: ['*.*', "!.icons/"],
            dest: grunt.constants.images.production
          }
        ]
      },
      fonts: {
        files: [
          {
            expand: true,
            cwd: grunt.constants.fonts.development,
            src: ['*'],
            dest: grunt.constants.fonts.production
          }
        ]
      },
      ace: {
        files: [
          {
            expand: true,
            cwd: grunt.constants.ace.development,
            src: ['*'],
            dest: grunt.constants.ace.production
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
    },

    imagemin: {
      png: {
        options: {
          optimizationLevel: 7
        },
        files: [{
          expand: true,
          cwd: grunt.constants.images.production,
          src: ["*.png"],
          dest: grunt.constants.images.production
        }]
      },
      jpg: {
        options: {
          progressive: true
        },
        files: [{
          expand: true,
          cwd: grunt.constants.images.production,
          src: ["*.jpg"],
          dest: grunt.constants.images.production
        }]
      },
      gif: {
        files: [{
          expand: true,
          cwd: grunt.constants.images.production,
          src: ["*.gif"],
          dest: grunt.constants.images.production
        }]
      }
    }

  });

  grunt.registerTask('default', ['compass:clean', 'compass:compile', 'normalize-concat']);

  grunt.registerTask('development', ['clean', 'compass:clean', 'compass:compile', 'normalize-concat', 'copy']);

  grunt.registerTask('production', ['clean', 'compass:clean', 'compass:compile', 'normalize-concat', 'uglify', 'cssmin', 'copy:images', 'imagemin', 'copy:fonts']);

  grunt.registerTask('sanitize', ['clean', 'compass:clean']);

}
