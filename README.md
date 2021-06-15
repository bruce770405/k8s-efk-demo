# K8s EFK demo

![image](https://github.com/bruce770405/k8s-efk-demo/blob/main/image.png)

### Install Minikube
```
brew cask install minikube
minikube start --memory=3000 --cpus=3
```
### Control command line
* kubectl
  * brew install kubectl
* helmenv
    * git clone https://github.com/yuya-takeyama/helmenv.git ~/.helmenv
    * echo 'export PATH="$HOME/.helmenv/bin:$PATH"' >> ~/.bash_profile or >> ~/.zshrc
    * helmenv install 3.5.1
    * helmenv global 3.5.1
    * helm plugin install https://github.com/databus23/helm-diff --version master
    
### Download and Install Istio (Optional)
  ```
  1. brew install istioctl
  2. minikube start --memory=8000 --cpus=4 ## use 8G memory and 4 core CPUs for minikube
  3. minikube tunnel --cleanup ## if you want to minikube offer you one LoadBalance for Istio，you can use minikube tunnel。 !notice suggest you open another Terminal for this command，because minikube tunnel will block your Terminal.
  4. istioctl install
  5. focus to minikube tunnel and keyin password to access  Starting tunnel for service istio-ingressgateway.
  ```
### Cmd
* create namespaces
  ```
  * kubectl create ns {namespace}
  ```
  * example: kubectl create ns app
  ```
  helm install -n {namespace} {helm-naming} ./helm/components/{component}/ --values ./helm/components/{component}/{values}.yaml
  ```
  * example: helm install -n default kibana ./helm/components/kibana/ --values ./helm/components/kibana/values.yaml
  * example: helm install -n default elasticsearch ./helm/components/elasticsearch/ --values ./helm/components/elasticsearch/values.yaml

* To be able to work with the docker daemon on your mac/linux host use the docker-env command in your shell:
  ```
  eval $(minikube docker-env)
  ```
### Install all log apps in minikube to demo
* spring-app build image
  ```
  in the spring-app maven project
  $ mvn jib:dockerBuild
  ```
* spring-app for demo
  ```
  move to helm/app/spring-app folder
  $ helm install -n default spring-app .
  ```
  
* Elasticsearch for minikube demo
  ```
  move to helm/components/elasticsearch folder
  $ minikube addons enable default-storageclass
  $ minikube addons enable storage-provisioner
  $ helm install -n default elasticsearch . --values ./example/minikube/values.yaml
  ```
* Kibana for minikube demo
  ```
  move to helm/components/kibana folder
  $ helm install -n default kibana .
  $ kubectl port-forward deployment/kibana-kibana 5601
  ```
  
* Fluentd for minikube demo
  ```
  move to helm/components/fluentd folder
  $ helm install -n default fluentd .
  ```
  
* Logstash for minikube demo (optional component)
  ```
  move to helm/components/logstash folder
  $ helm install -n default logstash  .
  ```


