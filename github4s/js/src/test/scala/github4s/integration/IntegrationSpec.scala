/*
 * Copyright 2016-2018 47 Degrees, LLC. <http://www.47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package github4s.integration

import fr.hmil.roshttp.response.SimpleHttpResponse
import github4s.HttpRequestBuilderExtension
import github4s.free.interpreters.{Capture, Interpreters}
import github4s.js.ImplicitsJS
import github4s.utils.{BaseIntegrationSpec, TestUtilsJS}

import scala.concurrent.Future

class IntegrationSpec
    extends BaseIntegrationSpec[SimpleHttpResponse]
    with GHAuthSpec[SimpleHttpResponse]
    with GHGitDataSpec[SimpleHttpResponse]
    with GHIssuesSpec[SimpleHttpResponse]
    with GHPullRequestsSpec[SimpleHttpResponse]
    with GHReposSpec[SimpleHttpResponse]
    with GHUsersSpec[SimpleHttpResponse]
    with GHActivitiesSpec[SimpleHttpResponse]
    with ImplicitsJS
    with TestUtilsJS {

  override implicit def extension(
      implicit capture: Capture[Future]): HttpRequestBuilderExtension[SimpleHttpResponse, Future] =
    extensionJS

  override implicit def futureInterpreters: Interpreters[Future, SimpleHttpResponse] =
    intInstanceFutureRosHttp
}
