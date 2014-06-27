package com.thpoiani.slidemd.interceptor;


import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

import com.thpoiani.slidemd.annotation.WithSession;
import com.thpoiani.slidemd.component.UserSession;
import com.thpoiani.slidemd.controllers.EnterController;

/**
 * Interceptor baseado no artigo "Controle de Login com VRaptor 3" de Washington Botelho
 * @article http://wbotelhos.com.br/2010/04/07/controle-de-login-com-vraptor-3
 */

@Intercepts
public class WithSessionInterceptor implements Interceptor {

	private Result result;
	private UserSession userSession;

	public WithSessionInterceptor(Result result, UserSession userSession) {
		this.result = result;
		this.userSession = userSession;
	}

	public boolean accepts(ResourceMethod method) {
		return (method.getMethod().isAnnotationPresent(WithSession.class) || method.getResource().getType().isAnnotationPresent(WithSession.class));
	}

	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) {
		if (userSession.isLogged()) {
			stack.next(method, resourceInstance);
		} else {
			result.redirectTo(EnterController.class).index();
		}
	}

}