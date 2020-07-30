package com.c7n.spring.bean.listInjection;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <功能描述>
 * ————————
 * <修改记录>
 * ————————
 *
 * @author jialong.wang
 * @Date on 2020/7/30 10:14 PM
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Mark {
}
