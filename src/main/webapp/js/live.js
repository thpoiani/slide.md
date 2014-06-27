(function(w, d, ace, $, undefined){
  'use strict';

  var editor = ace.edit(d.getElementById('editor')),
      save = d.getElementById('save'),
      form = d.getElementById('form'),
      iframe = d.getElementById('iframe');

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

  save.addEventListener('click', function(e) {
    e.preventDefault();

    $.post(form.getAttribute('action'), {
      "_method": "put",
      "presentation.id": form.querySelector('[name="presentation.id"]').value,
      "presentation.title": d.querySelector('.subtitle').innerText,
      "presentation.context": editor.getValue(),
      "presentation.active": true,
      "presentation.user.id": form.querySelector('[name="presentation.user.id"]').value
    }, function(response) {
      iframe.contentDocument.location.reload(true);
    });

  });

}(window, document, window.ace, window.jQuery));
