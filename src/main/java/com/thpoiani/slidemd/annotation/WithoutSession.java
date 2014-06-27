package com.thpoiani.slidemd.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation baseada no artigo "Controle de Login com VRaptor 3" de Washington Botelho
 * @article http://wbotelhos.com.br/2010/04/07/controle-de-login-com-vraptor-3
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })

public @interface WithoutSession {

}
