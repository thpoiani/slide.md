(function(w, d, ace, $, undefined){
  'use strict';

  var editor = ace.edit(d.getElementById('editor'));

  editor.setTheme('ace/theme/xcode');

  editor.getSession().setMode('ace/mode/markdown');
  editor.getSession().setUseWrapMode(true);
  editor.getSession().setUseSoftTabs(true);

  editor.commands.removeCommands([
    'showSettingsMenu', 'goToNextError', 'goToPreviousError',
    'centerselection', 'gotoline', 'fold', 'unfold', 'toggleFoldWidget',
    'toggleParentFoldWidget', 'foldall', 'foldOther', 'unfoldall',
    'findnext', 'findprevious', 'selectOrFindNext', 'selectOrFindPrevious',
    'find', 'togglerecording', 'replaymacro', 'jumptomatching',
    'selecttomatching', 'removeline', 'duplicateSelection', 'sortlines',
    'togglecomment', 'toggleBlockComment', 'modifyNumberUp',
    'modifyNumberDown', 'replace', 'copylinesup', 'movelinesup',
    'copylinesdown', 'movelinesdown', 'blockoutdent', 'blockindent',
    'splitline', 'transposeletters', 'touppercase', 'tolowercase'
  ]);

}(window, document, window.ace, window.jQuery));
