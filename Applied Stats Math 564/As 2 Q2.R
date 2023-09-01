Data =read.delim("AS_2_Q_2_Data.txt", header = FALSE, sep = " ")
Y=Data[,2]
X=Data[,6]
plot(X,Y)

Model=lm(Y~X)
Model

Beta0=as.numeric(Model$coefficients["(Intercept)"])
Beta1=as.numeric(Model$coefficients["X"])

#Y=2.11+0.03883X

plot(X,Y,xlab="ACT Test Score",ylab="Average GPA")
abline(Beta0,Beta1,col=2,lwd=2)

Y1=Beta0+Beta1*30

#The point estimate of change in mean response when entrance score is increased 
#by one point is Beta1 which is 0.0388

Y2=Beta0+Beta1*28
xnew = data.frame(X=28)

SXY = sum(X *Y ) - length(X) * mean(X) * mean(Y)
SYY = sum( Y * Y) - length(Y) * (mean(Y))^2
SXX = sum( X * X) - length(X) * (mean(X))^2
RSS = SYY - Beta1 * SXY
SIGMA=(RSS/(length(X)-2))^0.5
mu=mean(X)

n=0.05
t=qt(n/2, length(X)-2, lower.tail=TRUE)


confInt = predict(Model,xnew, interval = "confidence", level = 0.95, se.fit = TRUE)
conflwr=confInt$fit[2]
conflwr
confupr=confInt$fit[3]
confupr
ConfUb=Y2+t*SIGMA*((1/length(X))+((xnew-mu)^2/SXX))^0.5
ConfLb=Y2-t*SIGMA*((1/length(X))+((xnew-mu)^2/SXX))^0.5
ConfUb
ConfLb


predInt=predict(Model,xnew, interval = "prediction", level = 0.95, se.fit = TRUE)
predlwr=predInt$fit[2]
predlwr
predupr=predInt$fit[3]
predupr
PredUb=Y2+t*SIGMA*(1+(1/length(X))+((xnew-mu)^2/SXX))^0.5
PredLb=Y2-t*SIGMA*(1+(1/length(X))+((xnew-mu)^2/SXX))^0.5
PredUb
PredLb


Yes the Prediction intreval is wider than confidence interval. Because the prediction
model is used to estimate of the random samples rather than the confidence interval
which is an inference.



Weight = sqrt(2*qf(0.95,2,length(X)-2))

cbandupper = confInt$fit[,1]+Weight*confInt$se.fit
cbandlower = confInt$fit[,1]-Weight*confInt$se.fit
cbandlower
cbandupper

Yes the confidence band is little wider because it represents the entire regression line not 
only the sample at Xh=28

Anova =anova(Model)
Anova

MSR is the sum of squares due to regression taking degrees of freedom into account.

MSE is Mean Squared Error which is not a biased estimator of Standard Deviation
(Variance Squared).

When Beta1=0 or the slope of the regression equation is 0.


Let's Start Null Hypothesis Testing

H0: Beta1 is zero
Beta1=0

Ha: Beta1 is not Zero
Beta1!=0


alpha=0.01
Fscore = qf((1-alpha),1,length(X)-2)
Fscore

Summary(Model)
F* Score=0.07262

The absolute magnitude of reduction in variance of Y when X is introduced in
regression model is R Squared(R^2)

R=sqrt(0.07262) # from summary
R

R Squared gives claear cut interpretation. It describes the percent of variance 
of Y with respect to X. R square is usually used to represent the relation. It
takes values from 0 to 1.







