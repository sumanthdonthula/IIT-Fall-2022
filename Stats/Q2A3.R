Data=read.table("AS32Data.txt", header = FALSE, sep = "") 
Y = Data$V1
X = Data$V2
n=length(X)
Xf =cbind(rep(1,n),X)


Ymat=as.matrix(Y)
Xmat=as.matrix(Xf)


lm=lm(Y~X)
lm
anova(lm)

summary(lm)

sse = sum((fitted(lm) - Y)^2)

Sigmasquare=sse/n-2



#Working hotelling method
X1h=c(1,45)
X2h=c(1,55)
X3h=c(1,65)




Yhat1=156.35-1.19*45
Yhat2=156.35-1.19*55
Yhat3=156.35-1.19*65

measure1=(Sigmasquare*t(X1h)%*%solve(t(Xmat)%*%Xmat)%*%X1h)^0.5

measure2=(Sigmasquare*t(X2h)%*%solve(t(Xmat)%*%Xmat)%*%X2h)^0.5

measure3=(Sigmasquare*t(X3h)%*%solve(t(Xmat)%*%Xmat)%*%X3h)^0.5

W = sqrt(2 * qf(p = 0.95, df1 = 2, df2 = n - 2))


conf1up=Yhat1+W*measure1 
conf1lo=Yhat1-W*measure1  
conf2up=Yhat2+W*measure2 
conf2lo=Yhat2-W*measure2  
conf3up=Yhat3+W*measure3  
conf3lo=Yhat3-W*measure3  





BX1h=c(1,48)
BX2h=c(1,59)
BX3h=c(1,74)

Yhat11=156.35-1.19*48
Yhat21=156.35-1.19*59
Yhat31=156.35-1.19*74


Bmeasure1=(Sigmasquare*t(BX1h)%*%solve(t(Xmat)%*%Xmat)%*%BX1h)^0.5

Bmeasure2=(Sigmasquare*t(BX2h)%*%solve(t(Xmat)%*%Xmat)%*%BX2h)^0.5

Bmeasure3=(Sigmasquare*t(BX3h)%*%solve(t(Xmat)%*%Xmat)%*%BX3h)^0.5

B = qt(1-0.05/(2 * 3), n - 2)

conf11up=Yhat11+B*Bmeasure1
conf11lo=Yhat11-B*Bmeasure1  
conf22up=Yhat21+B*Bmeasure2 
conf22lo=Yhat21-B*Bmeasure2  
conf33up=Yhat21+B*Bmeasure3  
conf33lo=Yhat21-B*Bmeasure3

#Q8



