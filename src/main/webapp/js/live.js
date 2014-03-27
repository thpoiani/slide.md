(function(win, doc){
  'use strict';

  var Editor = {

    self: null,

    mutex: false,

    element : doc.getElementById('editor'),

    theme: 'ace/theme/xcode',

    highligth: 'ace/mode/markdown',

    initialize : function () {
      Editor.instanceAce();
      // Editor.markdownToSlide();
      Editor.saveEvent();
    },

    instanceAce: function() {
      var editor = ace.edit(this.element);

      editor.setTheme(this.theme);

      editor.getSession().setMode(this.highligth);
      editor.getSession().setUseWrapMode(true);
      editor.getSession().setUseSoftTabs(true);

      this.self = editor;
    },

    markdownToSlide: function() {
      var editor, slide;

      editor = this.self;
      slide = doc.getElementById('source');

      this.self.getSession().on('change', function(e) {
        slide.innerHTML = editor.getValue();
      });
    },

    saveEvent: function() {
      var keyPressed = {
          ctrl: function(event) {
            return (navigator.platform.match("Mac") ? event.metaKey : event.ctrlKey);
          },

          s: function(event) {
            return event.keyCode == 83;
          }
        }

      // CTRL+S
      doc.addEventListener('keydown', function(event) {
        if (keyPressed.ctrl(event) && keyPressed.s(event)) {
          event.preventDefault();

          Editor.postRequest(function() {
            // reload iframe
            document.getElementsByTagName('iframe')[0].contentDocument.location.reload(true);
          });
        }
      }, false);

      // TODO TIME
    },

    postRequest: function (callback) {
      var status = doc.getElementById('status');

      function saving() {
        status.innerText = 'saving';
      }

      function saved() {
        status.innerText = 'saved';
      }

      function error() {
        status.innerText = 'error';
      }

      if (!Editor.mutex) {
        Editor.mutex = true;

        saving();
        Editor.post(location.href, {data: this.self.getValue()}, function(response) {
          // TODO resultado

          if (response.success) {
            saved();

            if (typeof callback === 'function') {
              callback();
            }

            Editor.mutex = false;
          } else {
            error();
         }
        });
      }

    },

    post: function(url, data, callback) {
      var request, ajax;

      request = new XMLHttpRequest();

      request.open('POST', url);

      request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

      ajax = {
        isDone: function() {
          return request.readyState === 4;
        },

        isSuccess: function() {
          return request.status === 200;
        }
      }

      request.onreadystatechange = function() {
        if (ajax.isDone() && ajax.isSuccess()) {
          if (typeof callback === 'function') {
            callback(request.response);
          }
        } else if (ajax.isDone()) {
          console.error("Falha ao envio de requisição.");
        }
      };

      if (typeof data === 'object') {
          data = JSON.stringify(data);
      }

      request.send(data);
    }
  };

  Editor.initialize();

}(window, document));