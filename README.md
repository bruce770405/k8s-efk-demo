# K8s EFK demo

### Install Minikube
```
brew cask install minikube
minikube start --memory=8000 --cpus=3
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
    
### Download and Install Istio
````
1. brew install istioctl
2. minikube start --memory=8000 --cpus=4 ## 使用 8G 的 memory 和 4 core minikube CPUs
3. minikube tunnel --cleanup ## 如果你希望 minikube 提供一个LoadBalance给 Istio，你可以使用 minikube tunnel。 在另一個 Terminal 執行命令，因为 minikube tunnel 會block你的 Terminal 用來顯示網路訊息
4. istioctl install
5. focus to minikube tunnel and keyin password to access  Starting tunnel for service istio-ingressgateway.
````
### Cmd
kubectl create ns k8s-efk
* helm install -n default {namespace} ./helm/components/{component}/ -f ./helm/components/{component}/{values}.yaml
* example: helm install -n default kibana ./helm/components/kibana/ -f ./helm/components/kibana/values.yaml
* example: helm install -n default elasticsearch ./helm/components/elasticsearch/ -f ./helm/components/elasticsearch/values.yaml

### Install all log apps in minikube to demo
* Elasticsearch for minikube demo
  ```
  minikube addons enable default-storageclass
  minikube addons enable storage-provisioner
  helm install -n default elasticsearch ./helm/components/elasticsearch/ -f ./helm/components/elasticsearch/example/minikube/values.yaml
  ```
* Kibana for minikube demo
  ```
  helm install -n default kibana elastic/kibana
  kubectl port-forward deployment/kibana-kibana 5601
  ```
  
* Fluentd for minikube demo
  ```
  helm install -n default fluentd  ./helm/components/fluentd/ -f ./helm/components/fluentd/values.yaml
  ```


