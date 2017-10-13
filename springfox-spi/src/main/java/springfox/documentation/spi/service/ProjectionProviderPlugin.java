/*
 *
 *  Copyright 2017 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */

package springfox.documentation.spi.service;

import org.springframework.plugin.core.Plugin;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.members.ResolvedField;
import com.google.common.base.Optional;

import springfox.documentation.service.ResolvedMethodParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.OperationContext;
import springfox.documentation.spi.service.contexts.RequestMappingContext;

public interface ProjectionProviderPlugin extends Plugin<DocumentationType> {

  /**
   * Finds a active projection for the parameter type
   * @param type - resolved type to provide projection for
   * @param parameter - resolved method parameter to take additional information from, if needed 
   * @return resolved projection name, if found
   */
  Optional<ResolvedType> projectionFor(ResolvedType type, ResolvedMethodParameter parameter);

  /**
   * Finds a active projection for the  return type
   * @param type - resolved type to provide projection for
   * @param context - method context to take additional information from, if needed 
   * @return resolved projection name, if found
   */
  Optional<ResolvedType> projectionFor(ResolvedType type, RequestMappingContext context);
  
  /**
   * Finds a active projection for the  return type
   * @param type - resolved type to provide projection for
   * @param context - operation context to take additional information from, if needed 
   * @return resolved projection name, if found
   */
  Optional<ResolvedType> projectionFor(ResolvedType type, OperationContext context);

  /**
   * Defines if a type is in a active projection
   * @param activeProjection - resolved projection type
   * @param field - field that contains additional information
   * @return true if active view in a type views, false otherwise
   */
  boolean applyProjection(ResolvedType activeProjection, ResolvedField field);

  /**
   * Defines if a type is in a active projection
   * @param typeViews - resolved type views
   * @return true if active view in a type views, false otherwise
   */
  boolean applyProjection(ResolvedType activeProjection, Class<?>[] typeViews);
}