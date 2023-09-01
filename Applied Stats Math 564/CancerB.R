rm(list=ls())
Data=read.table("data.csv", header = TRUE, sep = ",")

nrow(Data)
Data=na.omit(Data)
nrow(Data)

head(Data)


library(ggplot2)

# Scatter plot by group
ggplot(Data, aes(x = diagnosis, y = radius_mean, color = diagnosis)) 
#+
  #geom_point()


summary(Data)

meanIdx = grepl('mean', colnames(Data))

seIdx = grepl('se',colnames(Data))

worstIdx= grepl('worst',colnames(Data))


meanData=Data[meanIdx]

par(mfrow=c(3,5))

for(i in 1:ncol(meanData)) {       # for-loop over columns
  set.seed(seed = 49078)
  x <-  meanData[ , i]
  hist(main="Histogram", ylab="Distribution",xlab=colnames(meanData)[i],x = x, freq = FALSE)
  lines(x = density(x = x), col = "blue")
}

seData=Data[seIdx]

par(mfrow=c(3,5))
for(i in 1:ncol(seData)) {       # for-loop over columns
  set.seed(seed = 49078)
  x <-  seData[ , i]
  hist(main="Histogram", ylab="Distribution",xlab=colnames(seData)[i],x = x, freq = FALSE)
  lines(x = density(x = x), col = "blue")
}

worstData=Data[worstIdx]

par(mfrow=c(3,5))
for(i in 1:ncol(worstData)) {       # for-loop over columns
  set.seed(seed = 49078)
  x <-  worstData[ , i]
  hist(main="Histogram", ylab="Distribution",xlab=colnames(worstData)[i],x = x, freq = FALSE)
  lines(x = density(x = x), col = "blue")
}



par(mfrow=c(3,5))

for(i in 1:ncol(meanData)) {       # for-loop over columns
  set.seed(seed = 49078)
  x <-  meanData[ , i]
  boxplot(xlab=colnames(meanData)[i],x = x, freq = FALSE)
}

par(mfrow=c(3,5))

for(i in 1:ncol(seData)) {       # for-loop over columns
  set.seed(seed = 49078)
  x <-  seData[ , i]
  boxplot(xlab=colnames(seData)[i],x = x, freq = FALSE)
}

par(mfrow=c(3,5))
for(i in 1:ncol(worstData)) {       # for-loop over columns
  set.seed(seed = 49078)
  x <-  worstData[ , i]
  boxplot(xlab=colnames(worstData)[i],x = x, freq = FALSE)
}

Data$diagnosis <- ifelse(Data$diagnosis=='B', 1, 0)

df=abs(cor(Data[-1:-2],Data[2]))>0.7

df[df$value==TRUE,-2]

library(reshape2)

df=melt(df)


df$var2==TRUE

hist(x = x,freq = FALSE,xlim = c(0, 15))

var(Data$diagnosis)

hist(Data$diagnosis)

table(Data$diagnosis)


#+ perimeter_mean+ area_worst+ radius_mean

# Splitting dataset
split <- sample.split(Data, SplitRatio = 0.8)
split

train_reg <- subset(Data, split == "TRUE")
test_reg <- subset(Data, split == "FALSE")

# Training model
logistic_model <- glm(diagnosis~concave.points_worst+ perimeter_worst+ concave.points_mean
                      + radius_worst+ area_mean+ perimeter_mean+ area_worst+ radius_mean
                      ,family=quasibinomial("logit"),data = train_reg)



logistic_model

# Summary
summary(logistic_model)

predictDif=predict(logistic_model,data.frame(concave.points_worst=test_reg$concave.points_worst,perimeter_worst=test_reg$perimeter_worst,concave.points_mean=test_reg$concave.points_mean,radius_worst=test_reg$radius_worst,perimeter_mean=test_reg$perimeter_mean,area_worst=test_reg$area_worst,
                                             radius_mean=test_reg$radius_mean,area_mean=test_reg$area_mean),type="response")

library(InformationValue)

origTest=test_reg$diagnosis

#find optimal cutoff probability to use to maximize accuracy
optimal <- optimalCutoff(test_reg, predictDif)[1]
optimal

predictDif <- ifelse(predictDif>optimal, 1, 0)

#predictDif=data.frame(predictDif)


predictDif=predictDif
table(origTest, predictDif)


missing_classerr <- mean(predictDif != origTest)
print(paste('Accuracy =', 1 - missing_classerr))


library(pROC)
roc_score=roc(origTest, predictDif) #AUC score
plot(roc_score ,main ="ROC curve -- Logistic Regression ")

roc_score
table(origTest, predictDif)
table(Data$TenYearCHD)
print(paste('Accuracy =', 1 - missing_classerr))

