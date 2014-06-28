(function(w, d, ace, $, undefined){
  'use strict';

  var editor = ace.edit(d.getElementById('editor')),
      css = ace.edit(d.getElementById('css')),
      save = d.getElementById('save'),
      form = d.getElementById('form'),
      iframe = d.getElementById('iframe'),
      commands = [
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
      ];

  editor.setTheme('ace/theme/xcode');
  editor.getSession().setMode('ace/mode/markdown');
  editor.getSession().setUseWrapMode(true);
  editor.getSession().setUseSoftTabs(true);
  editor.commands.removeCommands(commands);

  css.setTheme('ace/theme/xcode');
  css.getSession().setMode('ace/mode/css');
  css.getSession().setUseWrapMode(true);
  css.getSession().setUseSoftTabs(true);
  css.setShowPrintMargin(false);
  css.commands.removeCommands(commands);

  save.addEventListener('click', function(e) {
    e.preventDefault();

    var self = this,
        method = form.querySelector('[name="_method"]'),
        id = form.querySelector('[name="presentation.id"]'),
        data = {
          "presentation.hash": form.querySelector('[name="presentation.hash"]').value,
          "presentation.title": d.querySelector('.subtitle').innerText,
          "presentation.context": editor.getValue(),
          "presentation.css": css.getValue(),
          "presentation.active": true,
          "presentation.user.id": form.querySelector('[name="presentation.user.id"]').value
        };

    if (method) data['_method'] = method.value;
    if (id) data['presentation.id'] = id.value;

    $.post(form.getAttribute('action'), data, function(response) {
      if (response.list) {
        var string = '';
        $.each(response.list, function(i, error){
          string += error.category + ' ' + error.message + '\n';
        });
        return alert(string);
      }

      if (iframe.getAttribute('src')) {
        iframe.contentDocument.location.reload(true);
      } else {
        var hash = response.presentation.hash;

        self.setAttribute('title', 'save presentation');
        self.innerText = 'SAVE';

        window.history.pushState(null, null, "/slide.md/presentation/" + hash + "/live");
        iframe.src = '/slide.md/presentation/' + hash;
      }
    });

  });

}(window, document, window.ace, window.jQuery));
