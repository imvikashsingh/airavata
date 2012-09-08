/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.apache.airavata.persistance.registry.jpa;

import org.apache.airavata.persistance.registry.jpa.resources.GatewayResource;
import org.apache.airavata.persistance.registry.jpa.resources.ProjectResource;
import org.apache.airavata.registry.api.AiravataRegistry2;

public class JPAResourceAccessor {
	private AiravataRegistry2 registry=null;
	private GatewayResource gatewayResource;
	private ResourceUtils resourceUtils = new ResourceUtils();
	
	public JPAResourceAccessor(AiravataRegistry2 registry) {
		this.registry=registry;
		gatewayResource = new GatewayResource();
		gatewayResource.setGatewayName(this.registry.getGateway().getGatewayName());
	}
	
	public GatewayResource getGateway(){
		return gatewayResource;
	}
	
	public ProjectResource createProject(String name){
		ProjectResource prj = (ProjectResource)getGateway().create(ResourceType.PROJECT);
		prj.setUserName(registry.getUser().getUserName());
		prj.setName(name);
		return prj;
	}
	
	public ResourceUtils root(){
		return resourceUtils;
	}
}
