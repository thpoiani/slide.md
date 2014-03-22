module.exports = function(grunt) {
  grunt.loadNpmTasks('grunt-contrib-concat');

  grunt.registerTask('normalize-concat', function() {
    var files = grunt.file.expand(grunt.constants.css.development + '*.css');

    files.forEach(function (file) {
      var name = file.replace(grunt.constants.css.development, '');

      var concat = grunt.config.get('concat') || {};

      concat[name] = {
        options: {
          banner: grunt.constants.banner,
          separator: '\n'
        },
        src: [grunt.constants.normalize, file],
        dest: file
      }

      grunt.config.set('concat', concat);
    });
    grunt.task.run('concat');
  });
};
