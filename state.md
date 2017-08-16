State is a gemorroy anywhere.

Mist is a service and it has a state: running jobs, workers, contexts, deployed jars, endpoints, etc. Endpoint is not a config. Enpoint (Job associated with context/cluster) is state as well since it’s a job deployed at particular context/cluster.
State could be changed from UI or API - it does not matter.
If we make user to manage the state - there is no much value here. User have to invent it’s own bike - Jenkins, scripts, folders, etc.

So Mist has to deal with this state and save it to optional key-value store. It could be etcd, zookeeper, consul, sqlite by default. 

Also there should be the way to bootstrap Mist cluster and jobs with initial state like Terraform or Cloudformation.

So, down to the earth.

We have a job - `.jar` file. It should be enough to deploy it at Mist.
Deploy to default context/cluster:
`cli/api/sbt/ui> mist deploy myjob.jar` 

Deploy to named context created before:
`cli/api/sbt/ui> mist deploy -c foo myjob.jar `

Preconfigure Mist and batch deploy
`mist-bootstrap.conf:`
```
clusters {
	streaming {
	}
	foo {
	}
}
job-repositories {
	maven = “”
	local = “/home/user/mist/examples”
	hdfs = “”
	s3 = “”
}
endpoints {
	predict {
		class = “”
		cluster = “foo”
	}
}
```

`cli/api/sbt/ui> mist deploy -b ./mist-bootstrap.conf`
