(function(win, doc){

  var Editor = {

    self: null,

    element : doc.getElementById('editor'),

    theme: 'ace/theme/xcode',

    highligth: 'ace/mode/markdown',

    initialize : function () {
      self = ace.edit(this.element);

      self.setTheme(this.theme);


      self.getSession().setMode(this.highligth);
      self.getSession().setUseWrapMode(true);
      self.getSession().setUseSoftTabs(true);


      self.getSession().on('change', function(e) {
         Editor.change();
      });
    },

    change: function () {
      Editor.post(location.href, {data: self.getValue()}, function(response) {
        console.log(response);
      });
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