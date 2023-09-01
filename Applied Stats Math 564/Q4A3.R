Data=read.table("As34Data.txt", header = FALSE, sep = "") 
Y = Data$V1
X1 = Data$V2
X2 = Data$V3
X3 = Data$V4
X4 = Data$V5
 
Xmat=as.matrix(cbind(rep(1,length(Y)),X1,X2,X3,X4))
Xmstem(X1)
stem(X2)
stem(X3)
stem(X4)

pairs(~Y+X1+X2+X3+X4)
colnames(Data)=c("Y","X1","X2","X3","X4")
cor(Data)

Lmod=lm(Y~X1+X2+X3+X4)
Lmod

Lmod$residuals

boxplot(Lmod$residuals)


#we see a pattern not a good fit 
#residuals are normally distributed and aligned
  
  
par(mfrow=c(2,3))
plot(Y,Lmod$residual)
plot(X1,Lmod$residual)
plot(X2,Lmod$residual)
plot(X3,Lmod$residual)
plot(X4,Lmod$residual)
plot(Lmod,which=2)

plot(X1,Lmod$residual)
plot(X2,Lmod$residual)
plot(X3,Lmod$residual)
plot(X1*X2,Lmod$residual)
plot(X2*X3,Lmod$residual)
plot(X3*X1,Lmod$residual)

Lmod2=lm(Y~X1+X2+X4)

anova(Lmod2,Lmod)

Yhat=sort(fitted(Lmod2))

Y1=Yhat[1:40]
Y2=Yhat[41:81]

e1=Y1-Y[1:40]
Med1=median(e1)

e2=Y2-Y[41:81]
Med2=median(e2)

n1=length(Y1)
n2=length(Y2)


d1=e1-Med1
Mean1=mean(d1)
d2=e2-Med2
Mean2=mean(d2)

s=sqrt(sum((d1-Mean1)^2)+sum((d2-Mean2)^2)/(length(Yhat)-2))

tstar=(Mean1-Mean2)/(s*sqrt((1/n1)+(1/n2)))
tstar
t=qt(0.05,df=n1+n2-2)
t




#Q5
anova(Lmod)

n=length(Y)
alpha=1 - 0.95
g=4
t=qt(1 - alpha/(2 * g), n - 4 - 1)
t
beta1 = coef(summary(Lmod))[,1][[2]]
beta2 = coef(summary(Lmod))[,1][[3]]
beta3 = coef(summary(Lmod))[,1][[4]]
beta4 = coef(summary(Lmod))[,1][[5]]

sebeta1 = coef(summary(Lmod))[,2][[2]]
sebeta2 = coef(summary(Lmod))[,2][[3]]
sebeta3 = coef(summary(Lmod))[,2][[4]]
sebeta4 = coef(summary(Lmod))[,2][[5]]
2
beta1
beta2
beta3
beta4
CIbeta1 = c(beta1 - t * sebeta1, beta1 + t * sebeta1)
CIbeta2 = c(beta2 - t * sebeta2, beta2 + t * sebeta2)
CIbeta3 = c(beta3 - t * sebeta3, beta3 + t * sebeta3)
CIbeta4 = c(beta4 - t * sebeta4, beta4 + t * sebeta4)


sse = sum((fitted(Lmod) - Y)^2)

sst=sum((Y-mean(Y))^2)

Rsquare=1-(sse/sst)


#Q6

Data2=read.table("As36.txt", header = FALSE, sep = "") 
n=nrow(Data2)
Xh1=t(cbind(rep(1,n),t(Data2$V1)))
Xh2=t(cbind(rep(1,n),t(Data2$V2)))
Xh3=t(cbind(rep(1,n),t(Data2$V3)))
Xh4=t(cbind(rep(1,n),t(Data2$V4)))
beta0=coef(summary(Lmod))[,1][[2]]

Bmat=cbind(beta0,beta1,beta2,beta3,beta4)
Bmat=as.matrix(Bmat)




Yhat1=Bmat%*%Xh1;
Yhat2=Bmat%*%Xh2;
Yhat3=Bmat%*%Xh3;
Yhat4=Bmat%*%Xh4;

sse = sum((fitted(Lmod) - Y)^2)

Sigmasquare=sse/n-2

measure1=(Sigmasquare*t(Xh1)%*%solve(t(Xmat)%*%Xmat)%*%Xh1)^0.5

measure2=(Sigmasquare*t(Xh2)%*%solve(t(Xmat)%*%Xmat)%*%Xh2)^0.5

measure3=(Sigmasquare*t(Xh3)%*%solve(t(Xmat)%*%Xmat)%*%Xh3)^0.5

measure4=(Sigmasquare*t(Xh4)%*%solve(t(Xmat)%*%Xmat)%*%Xh4)^0.5

W = sqrt(2 * qf(p = 0.95, df1 = 5, df2 = length(Y) - 5))


conf1up=Yhat1+W*measure1 
conf1lo=Yhat1-W*measure1  
conf2up=Yhat2+W*measure2 
conf2lo=Yhat2-W*measure2  
conf3up=Yhat3+W*measure3  
conf3lo=Yhat3-W*measure3  
conf4lo=Yhat3+W*measure3
conf4up=Yhat3-W*measure3

#Q7



Ycor  = sqrt(1/(length(Y)-1))*((Y-mean(Y))/sd(Y))
X1cor = sqrt(1/(length(X1)-1))*((X1-mean(X1))/sd(X1))
X2cor = sqrt(1/(length(X2)-1))*((X2-mean(X2))/sd(X2))
X3cor = sqrt(1/(length(X3)-1))*((X3-mean(X3))/sd(X3))
X4cor = sqrt(1/(length(X4)-1))*((X4-mean(X4))/sd(X4))

Betahat2=(sd(Y)/sd(X2))*-0.423

Betahat1=(sd(Y)/sd(X1))*-0.547
Betahat2=(sd(Y)/sd(X2))*-0.423
Betahat3=(sd(Y)/sd(X3))*-0.048
Betahat4=(sd(Y)/sd(X4))*-0.502


Lmodel=lm(Ycor~-1+X1cor+X2cor+X3cor+X4cor)
Lmodel

