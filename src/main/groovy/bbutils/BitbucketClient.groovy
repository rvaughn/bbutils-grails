package bbutils

import groovy.json.JsonSlurper

// TODO: figure out how to get RestClient
// import groovyx.net.http.RestClient

import org.apache.http.HttpHost
import org.apache.http.client.fluent.Executor
import org.apache.http.client.fluent.Request

class BitbucketClient {

  final static String BB_API1_BASE = "https://bitbucket.org/api/1.0"
  final static String BB_API2_BASE = "https://bitbucket.org/api/2.0"

  String account
  
  // def api1
  // def api2

  def parser
  def executor

  BitbucketClient(String user, String pass) {
    account = user
    // TODO: RestClient stuff
    //api1 = new RestClient(BB_API1_BASE)
    //api1.auth.basic(user, pass)
    //api2 = new RestClient(BB_API2_BASE)
    //api2.auth.basic(user, pass)
    parser = new JsonSlurper()
    executor = Executor.newInstance().auth(new HttpHost("bitbucket.org"), user, pass)
  }

  def get(String url) {
    executor.execute(Request.Get(url)).returnContent().asString()
  }

  def repos() {
    // TODO: RestClient stuff
    //def text = api2.get(path: "repositories/${account}")
    def text = get "${BB_API2_BASE}/repositories/${account}"
    parser.parseText(text)
  }

}

